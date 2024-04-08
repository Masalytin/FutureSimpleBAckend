package ua.dmjdev.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.dto.gpt.Message;
import ua.dmjdev.service.ChatGPTService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController()
public class ChatGPTController {
    private final ChatGPTService service;
    private final ObjectMapper objectMapper;

    {
        objectMapper = new ObjectMapper();
    }
    public ChatGPTController(ChatGPTService service) {
        this.service = service;
    }

    @PostMapping("/get-response")
    public String getResponse(@RequestBody List<Message> messages) throws IOException {
        return service.getResponse(messages).getContent();
    }
}
