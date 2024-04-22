package ua.dmjdev.models.tasks;

import lombok.Data;

@Data
public abstract class SentenceTask extends GrammarTask {
    protected String sentence;
}
