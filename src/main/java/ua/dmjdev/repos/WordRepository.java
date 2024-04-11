package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.dmjdev.models.dictionary.Word;

public interface WordRepository extends JpaRepository<Word, Long> {
}
