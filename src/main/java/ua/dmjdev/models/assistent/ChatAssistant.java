package ua.dmjdev.models.assistent;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.openai.api.OpenAiApi.ChatCompletionMessage.Role;
import ua.dmjdev.models.usr.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ChatAssistant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Theme theme;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;
    private LocalDateTime creationDateTime;

    public ChatAssistant(Theme theme) {
        this.theme = theme;
        this.messages = new ArrayList<>();
        addNewMessage(Role.SYSTEM, String.format("""
            You are an English teacher and you need to get into the role. Do not answer questions that are not relevant to your role and topic. Answer only in English. If the user communicates with you in another language, you should pretend not to understand. Focus on the user's level of English. If the user makes grammatical or vocabulary mistakes, correct them and continue the dialogue on a new line.
            Your role is a %s.
            The setting: a %s.
            The level of the user's English: %s
            """, theme.getRole(), theme, user.getEnglishLevel()));
        addNewMessage(Role.ASSISTANT, "Generate first message for start a dialog");
    }

    public void addNewMessage(Role role, String content) {
        this.messages.add(new Message(role, content));
    }

    public List<org.springframework.ai.chat.messages.Message> getSpringAIMessage() {
        List<org.springframework.ai.chat.messages.Message> result = new ArrayList<>();
        for (Message message : messages) {
            result.add(switch (message.getRole()) {
                case SYSTEM -> new SystemMessage(message.getContent());
                case USER -> new UserMessage(message.getContent());
                case ASSISTANT -> new AssistantMessage(message.getContent());
                case TOOL -> null;
            });
        }
        return result;
    }
}
