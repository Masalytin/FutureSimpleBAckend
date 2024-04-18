package ua.dmjdev.models.tasks;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ListenSentence extends Task implements Grammar, Listening, Vocabulary {

}
