package ua.dmjdev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/voice-assistant")
public class VoiceAssistantController {
    private String STATE_PROMPT = """
            
            """;

    @GetMapping("/get-state")
    public ResponseEntity<?> getState(
            @RequestParam String request
    ) {
        return null;
    }
}
