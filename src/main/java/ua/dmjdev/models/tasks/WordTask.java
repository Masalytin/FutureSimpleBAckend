package ua.dmjdev.models.tasks;

import jakarta.persistence.ManyToOne;
import ua.dmjdev.models.dictionary.Word;

public abstract class WordTask {
    @ManyToOne
    private Word word;
}
