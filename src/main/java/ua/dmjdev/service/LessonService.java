package ua.dmjdev.service;

import org.springframework.stereotype.Service;
import ua.dmjdev.dto.LessonTheme;
import ua.dmjdev.models.lesons.Lesson;
import ua.dmjdev.models.tasks.Task;
import ua.dmjdev.models.usr.User;

import java.util.List;
import java.util.Random;

@Service
public class LessonService {
    public List<Class<? extends Task>> RANDOM_TASKS = List.of();

    public Lesson createLessonForUserByTheme(User user, LessonTheme lessonTheme) {
        Lesson lesson = new Lesson();
        lesson.setUser(user);
        lesson.setTheme(lessonTheme);
        int randomIndex = (int) (Math.random() * RANDOM_TASKS.size());
        int randomTaskCount = new Random().nextInt(7, 12);
        for (int i = 0; i < randomTaskCount; i++) {
            switch (RANDOM_TASKS.get(randomIndex).getSimpleName()) {
                case "TranslateSentence" -> {

                }
                case "ListenSentence" -> {

                }
                case "SpeechReading" -> {

                }
                case "TranslateWord" -> {

                }
                default ->
                        throw new IllegalStateException("Unexpected value: " + RANDOM_TASKS.get(randomIndex).getSimpleName());
            }
        }
        return lesson;
    }
}
