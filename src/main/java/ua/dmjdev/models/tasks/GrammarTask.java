package ua.dmjdev.models.tasks;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ua.dmjdev.dto.Rule;

@Data
public abstract class GrammarTask extends Task {
    @Enumerated(EnumType.STRING)
    private Rule rule;
}
