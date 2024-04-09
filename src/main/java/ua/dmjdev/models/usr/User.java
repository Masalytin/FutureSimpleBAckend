package ua.dmjdev.models.usr;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private State state;
    private int experience;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RuleProgress> progressList;
}
