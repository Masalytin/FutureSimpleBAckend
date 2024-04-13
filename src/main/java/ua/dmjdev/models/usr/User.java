package ua.dmjdev.models.usr;

import jakarta.persistence.*;
import lombok.Data;
import ua.dmjdev.dto.EnglishLevel;
import ua.dmjdev.models.dictionary.WordProgress;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class User {
    @Id
    private long id;
    @Enumerated(EnumType.STRING)
    private State state;
    private int experience;
    @OneToMany(cascade = CascadeType.ALL)
    private List<RuleProgress> progressList;
    @Enumerated(EnumType.STRING)
    private EnglishLevel englishLevel;
    @OneToMany(cascade = CascadeType.ALL)
    private List<WordProgress> dictionary;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_buffer", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyJoinColumn(name = "param_key")
    @Column(name = "value", length = 1000)
    private Map<String, String> buffer;
    private LocalDateTime registrationDateTime;
    private LocalDate birthdate;

    public String getParamFromBuffer(String key) {
        String param = getBuffer().get(key);
        if (param == null)
            throw new IllegalStateException(String.format("$%s Param not found", key));
        return param;
    }


    public boolean hasParam(String param) {
        try {
            return getParamFromBuffer(param) != null;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public void addParamToBuffer(String key, String value) {
        buffer.put(key, value);
    }
}

