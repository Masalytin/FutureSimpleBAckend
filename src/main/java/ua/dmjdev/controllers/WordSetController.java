package ua.dmjdev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.models.dictionary.WordsSet;
import ua.dmjdev.repos.WordSetRepository;
import ua.dmjdev.service.WordService;

@RestController
@RequestMapping("/api/v1/word-set")
public class WordSetController {
    private final WordService wordService;
    private final WordSetRepository repository;

    public WordSetController(WordService wordService, WordSetRepository repository) {
        this.wordService = wordService;
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getWordSet(@PathVariable int id) {
        WordsSet wordsSet = repository.findById(id).orElse(null);
        if (wordsSet == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(wordsSet);
    }
}
