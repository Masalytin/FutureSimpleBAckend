package ua.dmjdev.controllers;

import org.springframework.web.bind.annotation.*;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.dto.gpt.Message;
import ua.dmjdev.dto.gpt.Role;
import ua.dmjdev.service.ChatGPTService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController()
public class ChatGPTController {
    private final ChatGPTService service;

    private final String SENTENCE_BY_RULE_PROMPT = "Create a sentence for the following rule: %s. Send only the sentence.";

    public ChatGPTController(ChatGPTService service) {
        this.service = service;
    }

    @PostMapping("/get-response")
    public String getResponse(@RequestBody List<Message> messages) throws IOException {
        return service.getResponse(messages).getContent();
    }

    @GetMapping("/sentence-by-rule")
    public String getSentenceByRule(@RequestParam(name = "rule", defaultValue = "PRESENT_SIMPLE") Rule rule) throws IOException {
        List<Message> messages = new ArrayList<>() {{
            add(new Message(){{
                setRole(Role.SYSTEM);
                setContent(String.format(SENTENCE_BY_RULE_PROMPT, rule));
            }});
        }};
        return service.getResponse(messages).getContent();
    }
}
