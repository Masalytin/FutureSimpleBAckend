package ua.dmjdev.controllers;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dmjdev.models.assistent.ChatAssistant;
import ua.dmjdev.models.assistent.Theme;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.ChatAssistantRepository;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.service.ChatAssistantService;

import java.util.Map;

@RestController()
@RequestMapping("/api/v1/chat-assistant")
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
            return ResponseEntity.status(404).body(Map.of("Error", "user not found"))
        ChatAssistant chatAssistant = new ChatAssistant(theme, user);
        chatAssistant.setUser(user);
        String response = chatClient.call(new Prompt(chatAssistant.getSpringAIMessage(), service.CHAT_OPTIONS))
                .getResult().getOutput().getContent();
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
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("Error", "user not found"));
        ChatAssistant chatAssistant = repository.findById(chatId).orElse(null);
        if (chatAssistant == null)
            return ResponseEntity.status(404).body(Map.of("Error", "chat not found"));
        if (!chatAssistant.getUser().equals(user))
            return ResponseEntity.status(301).body(Map.of("Error", "User is not chat creator"));
        String response = service.getResponse(chatAssistant, newMessageText).getContent();
        chatAssistant.addNewMessage(Role.ASSISTANT, response);
        repository.save(chatAssistant);
        return ResponseEntity.ok(response);
    }
}
