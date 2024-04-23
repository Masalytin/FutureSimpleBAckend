package ua.dmjdev.service.progress;

import org.springframework.stereotype.Service;
import ua.dmjdev.repos.WordProgressRepository;

@Service
public class WordProgressService {
    private final WordProgressRepository repository;

    public WordProgressService(WordProgressRepository repository) {
        this.repository = repository;
    }
}
