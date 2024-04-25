package ua.dmjdev.util;

import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import ua.dmjdev.dto.voice.assistant.State;

import java.util.ArrayList;
import java.util.Arrays;

public class PromptsUtil {
    public static final String SENTENCE_BY_RULE_PROMPT_FORMAT = """
            Create a sentence for the following rule: %s.
            Send only the sentence.
            """;
    public static final String CHAT_ASSISTANT_PROMPT_FORMAT = """
            You are an English teacher and you need to get into the role.
            If the user does not understand or asks to repeat it, just return REPEAT or REPEAT_ALL depending on the request
            If the user wants to stop communicating or is tired of the conversation, feel free to return them to the main page by return only BACK_TO_HOME_PAGE without other text.
            If the user asks for translation, return TRANSLATE.
            Do not answer questions that are not relevant to your role and topic.
            Answer only in English.
            Focus on the user's level of English.
            Your role is a %s.
            The theme is a %s.
            The level of the user's English is a %s
            """;
    public static final String GET_MISTAKES_IN_MESSAGE_PROMPT_FORMAT = """
            Вкажи на граматичні та лексичні помилки в тексті якщо помилки відсутні поверни ALL_ALRIGHT.
            Текст: %s.
            """;
    public static final String VOICE_ASSISTANT_PROMPT_FORMAT = """
            States in which the response was received: %s
            The user communicates with you in Ukrainian and he does not stun directly.
            You need to process the user's request and return the endpoint from the following array: %s.
            If it was not possible to determine the final current, return UNDEFINED.
            If the user does not understand or asks to repeat it, return REPEAT depending on the request.
            Send only the endpoint name
            """;

    public static Prompt getVoiceAssistantPrompt(State state, String userRequest) {
        OpenAiChatOptions chatOptions = new OpenAiChatOptions();
        chatOptions.setModel("gpt-4");
        chatOptions.setTemperature(1f);
        chatOptions.setMaxTokens(5);
        chatOptions.setTopP(1f);
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new AssistantMessage(String.format(VOICE_ASSISTANT_PROMPT_FORMAT, state.getDescription(), Arrays.toString(state.getAnswerOptions()))));
        messages.add(new UserMessage(userRequest));
        return new Prompt(messages, chatOptions);
    }
}
