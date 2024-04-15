package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.models.dictionary.Word;
import ua.dmjdev.repos.WordRepository;

@Service
public class WordService {
    private final WordRepository repository;

    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    // TODO: 15.04.2024 translate
    public Word saveWord(String name) {
        Word word = new Word();
        word.setName(name);
        repository.save(word);
        return word;
    }
}
