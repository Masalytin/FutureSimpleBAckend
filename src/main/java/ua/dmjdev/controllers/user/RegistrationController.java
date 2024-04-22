package ua.dmjdev.controllers.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.UserRepository;
import ua.dmjdev.models.usr.State;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private final UserRepository repository;

    public RegistrationController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public ResponseEntity<?> registration(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email
    ) {
        User user = repository.findByUsername(username);
        if (user != null)
            return ResponseEntity.status(300).body(Map.of("Error", "user with this username already exist"));
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setState(State.SELECT_ENGLISH_LEVEL);
        repository.save(newUser);
        return ResponseEntity.ok("Success");
    }
}
