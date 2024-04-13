package ua.dmjdev.models.assistent;

import jakarta.persistence.*;
import ua.dmjdev.models.usr.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class AssistantChat {
    @Id
    private long id;

    private Theme theme;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages;
    private LocalDateTime creationDateTime;
}
