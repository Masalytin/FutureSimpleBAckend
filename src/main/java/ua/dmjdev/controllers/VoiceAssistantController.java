package ua.dmjdev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.dto.voice.assistant.State;
import ua.dmjdev.service.VoiceAssistantService;

@RestController
@RequestMapping("/api/v1/voice-assistant")
public class VoiceAssistantController {
    private final VoiceAssistantService service;

    public VoiceAssistantController(VoiceAssistantService service) {
        this.service = service;
    }

    @GetMapping("/get-next-state")
    public ResponseEntity<?> getState(
            @RequestParam State currentState,
            @RequestParam String request
    ) {
        return ResponseEntity.ok(service.getNextState(currentState, request));
    }
}
