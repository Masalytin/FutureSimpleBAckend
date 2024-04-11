package ua.dmjdev.models.dictionary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import ua.dmjdev.dto.EnglishLevel;

@Entity
@Data
public class Word {
    @Id
    private Long id;
    // TODO: 11.04.2024 wordProgress.getWord().getWord()
    private String term;
    private EnglishLevel englishLevel;
}
