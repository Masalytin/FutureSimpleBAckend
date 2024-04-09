package ua.dmjdev.models.usr;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import ua.dmjdev.dto.Rule;

import java.time.LocalDateTime;

@Data
@Entity
public class RuleProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Rule rule;
    private byte progress;
    private LocalDateTime lastSuccessfulAttemptDateTime;

    public void setProgress(byte progress) {
        if (progress > 10 || progress < 0)
            throw new IllegalArgumentException("Progress must be from 0 to 10");
        this.progress = progress;
    }

    public void incProgress() {
        if (progress < 10)
            progress++;
    }

    public void decProgress() {
        if (progress > 0)
            progress--;
    }

    public void updateLastSuccessfulAttemptDateTime() {
        lastSuccessfulAttemptDateTime = LocalDateTime.now();
    }
}