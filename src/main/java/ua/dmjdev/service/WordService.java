package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.dto.Language;
import ua.dmjdev.models.dictionary.Word;
import ua.dmjdev.repos.WordRepository;

@Service
public class WordService {
    private final WordRepository repository;
    private final TranslateService translateService;

    public WordService(WordRepository repository, TranslateService translateService) {
        this.repository = repository;
        this.translateService = translateService;
    }

    public Word saveWord(String name) {
        Word word = new Word();
        word.setName(name);
        word.setTranslate(translateService.translate(name, Language.EN, Language.UK));
        repository.save(word);
        return word;
    }

    public Word getWord(String name) {
        Word word = repository.findByName(name);
        if (word == null)
            word = saveWord(name);
        return word;
    }
}
