package ua.dmjdev.models.tasks;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Data
public class TextOrderingTask extends Task implements Grammar, Reading, Vocabulary {

    public List<String> getMixedContentSentences() {
        List<String> sentences = new ArrayList<>();
        Collections.addAll(sentences, content.split("\\n"));
        Collections.shuffle(sentences, new Random());
        return sentences;
    }
}
