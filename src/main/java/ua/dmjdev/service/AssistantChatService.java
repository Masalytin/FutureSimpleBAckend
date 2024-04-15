package ua.dmjdev.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.stereotype.Service;

@Service
public class AssistantChatService {
    private final ChatClient chatClient;
    private static final PromptTemplate SYSTEM_MESSAGE_TEMPLATE = new SystemPromptTemplate("""
            Your goal teach user english
            """);

    public AssistantChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
}
