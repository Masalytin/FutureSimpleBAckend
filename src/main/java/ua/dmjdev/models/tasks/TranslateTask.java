package ua.dmjdev.models.tasks;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.Rule;

@Entity
@Data
public class TranslateTask extends Task {
    private String translate;
    @Enumerated(EnumType.STRING)
    private Rule rule;
}
