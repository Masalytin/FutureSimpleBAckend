package ua.dmjdev.service;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;
import org.springframework.stereotype.Service;
import ua.dmjdev.models.assistent.ChatAssistant;
import ua.dmjdev.util.PromptsUtil;

@Service
public class ChatAssistantService {
    private final ChatClient chatClient;
    public final OpenAiChatOptions CHAT_OPTIONS = new OpenAiChatOptions();

    {
        CHAT_OPTIONS.setModel("gpt-4");
        CHAT_OPTIONS.setTemperature(0.8f);
        CHAT_OPTIONS.setMaxTokens(50);
        CHAT_OPTIONS.setTopP(0.7f);
    }

    public ChatAssistantService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public Message getResponse(ChatAssistant chat, String userNewMessageContent) {
        chat.addNewMessage(Role.USER, userNewMessageContent);
        return chatClient.call(new Prompt(chat.getSpringAIMessage(), CHAT_OPTIONS)).getResult().getOutput();
    }

    public String getGrammarMistakesInMessage(String message) {
        return chatClient.call(new Prompt(
                String.format(PromptsUtil.GET_MISTAKES_IN_MESSAGE_PROMPT_FORMAT, message),
                CHAT_OPTIONS
        )).getResult().getOutput().getContent();
    }
}
