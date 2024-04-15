package ua.dmjdev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.dto.Language;
import ua.dmjdev.models.tasks.TranslateTask;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.TranslateTaskRepository;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.service.TranslateTaskService;

@RestController("/translate-task")
public class TranslateTaskControllers {
    private final TranslateTaskRepository repository;
    private final TranslateTaskService service;
    private final UserRepository userRepository;

    public TranslateTaskControllers(TranslateTaskRepository repository, TranslateTaskService service, UserRepository userRepository) {
        this.repository = repository;
        this.service = service;
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TranslateTask> getTask(@PathVariable Long id) {
        TranslateTask task = repository.findById(id).orElse(null);
        if (task == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(task);
    }

    @GetMapping("/random-for-user")
    public ResponseEntity<TranslateTask> getRandomTaskForUser(@RequestParam("user_id") long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();
        TranslateTask newTask = service.generateRandomTaskForUser(user);
        return ResponseEntity.ok(newTask);
    }

    @GetMapping("/check-answear")
    public ResponseEntity<Boolean> checkTaskAnswear(
            @RequestParam("task_id") long taskId,
            @RequestParam("answear") String answear,
            @RequestParam("target_language") Language targetLanguage
    ) {
        TranslateTask task = repository.findById(taskId).orElse(null);
        if (task == null)
            return ResponseEntity.notFound().build();
        return switch (targetLanguage) {
            case UK -> ResponseEntity.ok(task.getTranslate().equals(answear));
            case EN -> ResponseEntity.ok(task.getContent().equals(answear));
        };
    }
}
