package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.models.tasks.Task;

import java.util.List;

@Service
public class LessonService {
    public List<Class<? extends Task>> RANDOM_TASKS = List.of();
}
