package ua.dmjdev.models.usr;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.EnglishLevel;
import ua.dmjdev.models.dictionary.WordProgress;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private State state;
    private int experience;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RuleProgress> progressList;
    @Enumerated(EnumType.STRING)
    private EnglishLevel englishLevel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<WordProgress> dictionary;
}

