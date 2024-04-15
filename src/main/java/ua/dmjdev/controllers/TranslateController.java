package ua.dmjdev.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.dmjdev.dto.Language;
import ua.dmjdev.service.TranslateService;

@RestController
@RequestMapping("/translate")
public class TranslateController {
    private final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String getTranslation(@RequestParam String text, @RequestParam String sourceLanguage,
                                 @RequestParam String targetLanguage) {
        try {
            return translateService.translateText(text, Language.valueOf(sourceLanguage),
                    Language.valueOf(targetLanguage));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Illegal language");
        }
    }
}
