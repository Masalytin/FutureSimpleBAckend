package ua.dmjdev.models.tasks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public abstract class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected String content;
}
