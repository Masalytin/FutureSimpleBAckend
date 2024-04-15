package ua.dmjdev.models.dictionary;

import jakarta.persistence.*;
import ua.dmjdev.dto.EnglishLevel;

import java.util.List;

@Entity
public class WordsSet {
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private EnglishLevel englishLevel;
    @OneToMany
    private List<Word> words;
}
