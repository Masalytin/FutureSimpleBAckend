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

    public Word saveWord(String term) {
        Word word = new Word();
        word.setTerm(term);
        // TODO: 11.04.2024 Select word language level
        repository.save(word);
        return word;
    }
}
