package ua.dmjdev.models.dictionary;

import jakarta.persistence.*;
import ua.dmjdev.dto.Level;

import java.util.List;

@Entity
public class WordsSet {
    @Id
    private int id;
    @Enumerated(EnumType.STRING)
    private Level level;
    @OneToMany
    private List<Word> words;
}
