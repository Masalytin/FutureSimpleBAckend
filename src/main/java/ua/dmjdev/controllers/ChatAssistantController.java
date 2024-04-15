package ua.dmjdev.controllers;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.models.assistent.ChatAssistant;
import ua.dmjdev.models.assistent.Theme;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.ChatAssistantRepository;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.service.ChatAssistantService;

import java.util.Map;

@RestController()
public class ChatAssistantController {
    private final ChatClient chatClient;
    private final ChatAssistantRepository repository;
    private final ChatAssistantService service;
    private final UserRepository userRepository;

    public ChatAssistantController(ChatClient chatClient, ChatAssistantRepository repository, ChatAssistantService service, UserRepository userRepository) {
        this.chatClient = chatClient;
        this.repository = repository;
        this.service = service;
        this.userRepository = userRepository;
    }

    @PostMapping("/new-chat")
    public ResponseEntity<?> getNewChat(
            @RequestParam("theme") Theme theme,
            @RequestParam("user_id") long userId
    ) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();
        ChatAssistant chatAssistant = new ChatAssistant(theme);
        chatAssistant.setUser(user);
        String response = chatClient.call(new Prompt(chatAssistant.getSpringAIMessage())).getResult().getOutput().getContent();
        chatAssistant.addNewMessage(Role.ASSISTANT, response);
        repository.save(chatAssistant);
        return ResponseEntity.ok(Map.of(
                "chat-id", chatAssistant.getId(),
                "message", response
        ));
    }

    @GetMapping("/get-response")
    public ResponseEntity<?> getResponse(
            @RequestParam("chat-id") long chatId,
            @RequestParam("user-id") long userId,
            @RequestParam("new-message-text") String newMessageText
    ) {
        User user = userRepository.findById(userId).orElse(null);
        // TODO: 15.04.2024 Rewrite with errors
        if (user == null)
            return ResponseEntity.notFound().build();
        ChatAssistant chatAssistant = repository.findById(chatId).orElse(null);
        if (chatAssistant == null)
            return ResponseEntity.notFound().build();
        if (!chatAssistant.getUser().equals(user))
            return ResponseEntity.badRequest().build();
        String response = service.getResponse(chatAssistant, newMessageText).getContent();
        chatAssistant.addNewMessage(Role.ASSISTANT, response);
        repository.save(chatAssistant);
        return ResponseEntity.ok(response);
    }
}
