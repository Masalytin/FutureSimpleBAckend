package ua.dmjdev.models.tasks.grammar;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.tasks.SentenceTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Data
public class TranslateSentence extends SentenceTask {
    private String translate;
    @Enumerated(EnumType.STRING)
    private Rule rule;

    public List<String> getShuffleContentWords() {
        Pattern pattern = Pattern.compile("[\\w']+");
        Matcher matcher = pattern.matcher(sentence);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        Collections.shuffle(words, new Random());
        return words;
    }

    public List<String> getShuffleTranslateWords() {
        Pattern pattern = Pattern.compile("[\\w']+");
        Matcher matcher = pattern.matcher(translate);
        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        Collections.shuffle(words, new Random());
        return words;
    }
}
