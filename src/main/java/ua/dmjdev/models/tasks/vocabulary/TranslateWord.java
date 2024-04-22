package ua.dmjdev.models.tasks.vocabulary;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.Language;
import ua.dmjdev.models.dictionary.Word;

@Entity
@Data
public class TranslateWord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Word word;
    @Enumerated(EnumType.STRING)
    private Language targetLanguage;
}
