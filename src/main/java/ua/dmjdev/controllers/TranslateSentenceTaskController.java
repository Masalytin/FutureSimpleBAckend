package ua.dmjdev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dmjdev.dto.Language;
import ua.dmjdev.models.dictionary.WordProgress;
import ua.dmjdev.models.tasks.TranslateSentence;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.TranslateSentenceTaskRepository;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.repos.WordProgressRepository;
import ua.dmjdev.service.TranslateSentenseTaskService;
import ua.dmjdev.service.WordService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/translate-task")
public class TranslateSentenceTaskController {
    private final TranslateSentenceTaskRepository repository;
    private final TranslateSentenseTaskService service;
    private final UserRepository userRepository;
    private final WordProgressRepository wordProgressRepository;
    private final WordService wordService;

    public TranslateSentenceTaskController(TranslateSentenceTaskRepository repository, TranslateSentenseTaskService service, UserRepository userRepository, WordProgressRepository wordProgressRepository, WordService wordService) {
        this.repository = repository;
        this.service = service;
        this.userRepository = userRepository;
        this.wordProgressRepository = wordProgressRepository;
        this.wordService = wordService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        TranslateSentence task = repository.findById(id).orElse(null);
        if (task == null)
            return ResponseEntity.status(404).body(Map.of("Error", "task not found"));
        return ResponseEntity.ok(task);
    }

    @GetMapping("/random-for-user")
    public ResponseEntity<?> getRandomTaskForUser(@RequestParam("user_id") long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("Error", "task not found"));
        TranslateSentence newTask = service.generateRandomTaskForUser(user);
        return ResponseEntity.ok(newTask);
    }

    @GetMapping("/check-answear")
    public ResponseEntity<?> checkTaskAnswear(
            @RequestParam("user-id") long userId,
            @RequestParam("task_id") long taskId,
            @RequestParam("answear") String[] answear,
            @RequestParam("target_language") Language targetLanguage
    ) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("Error", "user not found"));
        TranslateSentence task = repository.findById(taskId).orElse(null);
        if (task == null)
            return ResponseEntity.status(404).body(Map.of("Error", "task not found"));
        List<String> targetWords = switch (targetLanguage) {
            case UK -> task.getShuffleTranslateWords();
            case EN -> task.getShuffleContentWords();
        };
        Map<Integer, Boolean> response = new HashMap<>();
        for (int i = 0; i < answear.length; i++) {
            WordProgress wordProgress = wordProgressRepository.findByUserAndWordName(user, answear[i]);
            if (wordProgress == null) {
                wordProgress = new WordProgress();
                wordProgress.setUser(user);
                wordProgress.setProgress((byte) 0);
                wordProgress.setWord(wordService.getWord(answear[i]));
                wordProgressRepository.save(wordProgress);
            }
            if (answear[i].equals(targetWords.get(i))) {
                wordProgress.incProgress();
                wordProgressRepository.save(wordProgress);
                response.put(i, true);
            } else {
                response.put(i, false);
            }
        }
        return ResponseEntity.ok(response);
    }
}
