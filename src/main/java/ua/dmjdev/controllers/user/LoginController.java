package ua.dmjdev.controllers.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dmjdev.models.usr.User;
import ua.dmjdev.repos.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    private final UserRepository repository;

    public LoginController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public ResponseEntity<?> login(
        @RequestParam("username") String username,
        @RequestParam("password") String password
    ) {
        User user = repository.findByUsername(username);
        if (user == null)
            return ResponseEntity.status(404).body(Map.of("Error", "user not found"));
        if (!user.getPassword().equals(password))
            return ResponseEntity.status(404).body(Map.of("Error", "incorrect password"));
        return ResponseEntity.ok("Success");
    }
}
