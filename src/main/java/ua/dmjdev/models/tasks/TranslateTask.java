package ua.dmjdev.models.tasks;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.Rule;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Data
@Table(name = "translate_tasks")
public class TranslateTask extends Task {
    private String translate;
    @Enumerated(EnumType.STRING)
    private Rule rule;

    public List<String> getShuffleContentWords() {
        Pattern pattern = Pattern.compile("[\\w']+");
        Matcher matcher = pattern.matcher(content);
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
