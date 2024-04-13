package ua.dmjdev.models.assistent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;

@Entity
public class Message {
    @Id
    private long id;
    private Role role;
    private String content;
}
