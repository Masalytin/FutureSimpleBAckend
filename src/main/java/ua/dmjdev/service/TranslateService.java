package ua.dmjdev.service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.Translate.TranslateOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Language;

@Service
public class TranslateService {

    private final Translate translate;

    public TranslateService(@Value("${google.translate.api.key}") String googleTranslateAPIKey) {
        translate = TranslateOptions.newBuilder().setApiKey(googleTranslateAPIKey).build()
                .getService();
    }

    public String translateText(String text, Language sourceLanguage, Language targetLanguage) {
        TranslateOption sourceLanguageOption = TranslateOption.sourceLanguage(sourceLanguage.name());
        TranslateOption targetLanguageOption = TranslateOption.targetLanguage(targetLanguage.name());
        Translation translation = translate.translate(text, sourceLanguageOption, targetLanguageOption);
        return translation.getTranslatedText();
    }

}
