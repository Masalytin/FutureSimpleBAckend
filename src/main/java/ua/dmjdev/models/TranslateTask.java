package ua.dmjdev.models;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.Rule;

@Entity
@Data
public class TranslateTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @Enumerated(EnumType.STRING)
    private Rule rule;
}
