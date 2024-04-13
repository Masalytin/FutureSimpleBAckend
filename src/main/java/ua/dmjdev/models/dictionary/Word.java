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
    private String term;
    private String translate;
    private String transcription;
}
