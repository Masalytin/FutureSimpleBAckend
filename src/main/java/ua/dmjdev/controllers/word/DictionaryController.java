package ua.dmjdev.controllers.word;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.models.dictionary.WordProgress;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.repos.WordProgressRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/api/v1/dictionary")

public class DictionaryController {
    private final UserRepository userRepository;
    private final WordProgressRepository wordProgressRepository;

    public DictionaryController(UserRepository userRepository, WordProgressRepository wordProgressRepository) {
        this.userRepository = userRepository;
        this.wordProgressRepository = wordProgressRepository;
    }

    @GetMapping("/count-for-user")
    public ResponseEntity<?> countForUser(
            @RequestParam("user-id") long userId
    ) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("error", "User not found"));
        return ResponseEntity.ok(user.getDictionary().size());
    }

    @GetMapping("/page-for-user")
    public ResponseEntity<?> pageForUser(
            @RequestParam("user-id") long userId,
            @RequestParam("page") int page,
            @RequestParam("page-size") int pageSize

    ) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("error", "User not found"));
        if (page * pageSize - pageSize > user.getDictionary().size())
            return ResponseEntity.status(400).body(Map.of("error", "Page too big"));
        List<WordProgress> pageByUser = wordProgressRepository.getPageByUser(user, page - 1, pageSize);
        Map<String, Byte> response = new HashMap<>();
        for (WordProgress wordProgress : pageByUser) {
            response.put(wordProgress.getWord().getName(), wordProgress.getProgress());
        }
        return ResponseEntity.ok(response);
    }
}
