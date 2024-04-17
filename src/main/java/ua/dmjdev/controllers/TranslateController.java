package ua.dmjdev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dmjdev.dto.Language;
import ua.dmjdev.service.TranslateService;

@RestController
@RequestMapping("/api/v1/translate")
public class TranslateController {
    private final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @GetMapping("/get-translation")
    public ResponseEntity<String> getTranslation(
            @RequestParam String text,
            @RequestParam String sourceLanguage,
            @RequestParam String targetLanguage
    ) {
        try {
            return ResponseEntity.ok(translateService.translate(text, Language.valueOf(sourceLanguage),
                    Language.valueOf(targetLanguage)));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Illegal language");
        }
    }
}
