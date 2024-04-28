package ua.dmjdev.controllers.word;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dmjdev.dto.EnglishLevel;
import ua.dmjdev.models.dictionary.WordsSet;
import ua.dmjdev.repos.WordSetRepository;
import ua.dmjdev.service.WordService;

import java.util.List;
import java.util.Map;

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
            return ResponseEntity.status(404).body(Map.of("error", "Word set not found"));
        return ResponseEntity.ok(wordsSet);
    }

    @GetMapping("/by-name")
    public ResponseEntity<?> getWordSetByName(@RequestParam String name) {
        WordsSet wordsSet = repository.findFirstByName(name);
        if (wordsSet == null)
            return ResponseEntity.status(404).body(Map.of("error", "Word set not found"));
        return ResponseEntity.ok(wordsSet.getWords().stream().map(w -> w.getName()).toList());
    }

    @GetMapping("/get-word-sets-by-level")
    public ResponseEntity<?> getWordSetsByLevel(
            @RequestParam("english-level") EnglishLevel level
    ) {
        List<WordsSet> wordsSets = repository.findByEnglishLevel(level);
        return ResponseEntity.ok(wordsSets.stream().map(w -> w.getName()).toList());
    }
}
