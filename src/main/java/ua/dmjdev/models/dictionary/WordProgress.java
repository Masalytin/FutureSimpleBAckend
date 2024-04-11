package ua.dmjdev.models.dictionary;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class WordProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
