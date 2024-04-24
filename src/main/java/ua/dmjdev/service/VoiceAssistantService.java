package ua.dmjdev.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.stereotype.Service;
import ua.dmjdev.dto.voice.assistant.State;
import ua.dmjdev.util.PromptsUtil;

@Service
public class VoiceAssistantService {
    private final ChatClient chatClient;


    public VoiceAssistantService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getState(State currentState, String userRequest) {
        return chatClient.call(PromptsUtil.getVoiceAssistantPrompt(currentState, userRequest))
                .getResult().getOutput().getContent();
    }
}
