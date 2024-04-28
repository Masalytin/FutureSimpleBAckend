package ua.dmjdev.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.dmjdev.models.lesons.Lesson;
import ua.dmjdev.repos.LessonRepository;

@Controller
@RequestMapping("/api/v1/lesson")
public class LessonController {
    private final LessonRepository repository;

    public LessonController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLesson(@PathVariable long id) {
        Lesson lesson = repository.findById(id).orElse(null);
        if (lesson == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lesson);
    }
}
