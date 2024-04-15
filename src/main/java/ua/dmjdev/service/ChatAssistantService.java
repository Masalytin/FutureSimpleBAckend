package ua.dmjdev.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;
import org.springframework.stereotype.Service;
import ua.dmjdev.models.assistent.ChatAssistant;

@Service
public class ChatAssistantService {
    private final ChatClient chatClient;

    public ChatAssistantService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Message getResponse(ChatAssistant chat, String userNewMessageContent) {
        chat.addNewMessage(Role.USER, userNewMessageContent);
        return chatClient.call(new Prompt(chat.getSpringAIMessage())).getResult().getOutput();
    }
}
