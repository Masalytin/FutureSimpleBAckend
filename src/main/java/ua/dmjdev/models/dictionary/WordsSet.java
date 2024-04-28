package ua.dmjdev.models.dictionary;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.EnglishLevel;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class WordsSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private EnglishLevel englishLevel;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Word> words;

    public WordsSet() {
        this.words = new ArrayList<>();
    }
}
