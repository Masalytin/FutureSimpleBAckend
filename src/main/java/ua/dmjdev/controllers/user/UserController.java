package ua.dmjdev.controllers.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dmjdev.models.dictionary.WordsSet;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.repos.WordSetRepository;
import ua.dmjdev.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;
    private final UserRepository repository;
    private final WordSetRepository wordSetRepository;

    public UserController(UserService service, UserRepository repository, WordSetRepository wordSetRepository) {
        this.service = service;
        this.repository = repository;
        this.wordSetRepository = wordSetRepository;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(
            @PathVariable("id") long userId
    ) {
        User user = repository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("Error", "user not found"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/add-words-from-word-set")
    public ResponseEntity<?> addWordsFromWordSet(
            @RequestParam("user-id") long userId,
            @RequestParam("word-set-id") int wordSetId
    ) {
        User user = repository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("Error", "user not found"));
        WordsSet wordsSet = wordSetRepository.findById(wordSetId).orElse(null);
        if (wordsSet == null)
            return ResponseEntity.status(404).body(Map.of("Error", "word set not found"));
        service.addWordFromWordsSetToUserDictionary(user, wordsSet);
        return ResponseEntity.ok("success");
    }

    @GetMapping("{id}/buffer")
    public ResponseEntity<?> getBuffer(@PathVariable("id") long userId) {
        User user = repository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("Error", "user not found"));
        return ResponseEntity.ok(user.getBuffer());
    }
}
