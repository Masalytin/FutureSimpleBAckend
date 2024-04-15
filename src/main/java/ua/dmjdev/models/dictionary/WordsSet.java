package ua.dmjdev.models.dictionary;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.EnglishLevel;

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
    @OneToMany
    private List<Word> words;
}
