package ua.dmjdev.models.lesons;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.LessonTheme;
import ua.dmjdev.models.tasks.Task;
import ua.dmjdev.models.usr.User;

import java.util.List;
import java.util.Queue;
import java.util.Set;

@Entity
@Data
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LessonTheme theme;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Task> tasks;
    @ManyToMany
    private Set<Task> completedTasks;
    @ManyToMany
    private Queue<Task> uncompletedTasks;
    private byte lives;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Lesson() {
        this.lives = 3;
    }

    private void setLives(byte lives) {}

    public void decrementLives() {
        this.lives--;
    }

    public enum Status {
        IN_PROGRESS, COMPLETED, UNCOMPLETED
    }
}
