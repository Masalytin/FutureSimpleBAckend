package ua.dmjdev.controllers;

import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.AssistantPromptTemplate;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.*;
import ua.dmjdev.dto.Rule;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController()
public class ChatGPTController {
    private final OpenAiChatClient chatClient;

    private final PromptTemplate SENTENCE_BY_RULE_PROMPT_TEMPLATE = new AssistantPromptTemplate("Create a sentence for the following rule: {rule}. Send only the sentence.");

    public ChatGPTController(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }


    @PostMapping("/get-response")
    public String getResponse(@RequestBody List<Message> messages) {
        Prompt prompt = new Prompt(messages);
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }


    @GetMapping("/sentence-by-rule")
    public String getSentenceByRule(@RequestParam(name = "rule", defaultValue = "PRESENT_SIMPLE") Rule rule) throws IOException {
        OpenAiChatOptions options = new OpenAiChatOptions();
        options.setModel("gtp-4");
        options.setMaxTokens(200);
        options.setTemperature(1f);
        return chatClient.call(SENTENCE_BY_RULE_PROMPT_TEMPLATE.create(Map.of("rule", rule))).getResult().getOutput().getContent();
    }
}
