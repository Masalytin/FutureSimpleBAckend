package ua.dmjdev.models.dictionary;

import com.google.api.Usage;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.dmjdev.models.usr.User;

@Entity
@Data
@NoArgsConstructor
public class WordProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    private Word word;
    private byte progress;

    public WordProgress(Word word) {
        this.word = word;
        this.progress = 0;
    }

    public void setProgress(byte progress) {
        if (progress > 5 || progress < 0)
            throw new IllegalArgumentException("Progress must be from 0 to 5");
        this.progress = progress;
    }

    public void incProgress() {
        if (progress < 5)
            progress++;
    }

    public void decProgress() {
        if (progress > 0)
            progress--;
    }
}
