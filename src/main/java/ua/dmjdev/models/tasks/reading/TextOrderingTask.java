package ua.dmjdev.models.tasks.reading;

import jakarta.persistence.Entity;
import lombok.Data;
import ua.dmjdev.models.tasks.Task;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

@Entity
@Data
public class TextOrderingTask extends Task {
    private String content;

    public List<String> getMixedContentSentences() {
        List<String> sentences = new ArrayList<>();
        content += " ";
        Collections.addAll(sentences, content.split("[.!?]+"));
        Collections.shuffle(sentences, new Random());
        return sentences;
    }
}


