package ua.dmjdev.models.tasks;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Entity
@Data
public class ReadingTask extends Task {

    public List<String> getMixedContentSentences() {
        List<String> sentences = List.of(content.split("\\n"));
        Collections.shuffle(sentences, new Random());
        return sentences;
    }
}
