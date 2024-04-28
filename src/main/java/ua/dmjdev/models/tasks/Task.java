package ua.dmjdev.models.tasks;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.Rule;

@Entity
@Data
public abstract class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
