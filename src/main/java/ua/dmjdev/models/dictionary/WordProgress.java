package ua.dmjdev.models.dictionary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ua.dmjdev.models.usr.User;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WordProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Word word;
    private byte progress;
    private LocalDate creationDate;

    public WordProgress(Word word) {
        this.word = word;
        this.progress = 0;
        this.creationDate = LocalDate.now();
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
