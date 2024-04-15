package ua.dmjdev.models.assistent;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;

@Entity
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Role role;
    @Column(length = 500)
    private String content;

    public Message(Role role, String content) {
        this.role = role;
        this.content = content;
    }
}
