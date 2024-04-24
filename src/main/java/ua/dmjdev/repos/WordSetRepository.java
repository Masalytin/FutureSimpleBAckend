package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.dto.EnglishLevel;
import ua.dmjdev.models.dictionary.WordsSet;

import java.util.List;

@Repository
public interface WordSetRepository extends JpaRepository<WordsSet, Integer> {
    WordsSet findFirstByName(String name);
    List<WordsSet> findByEnglishLevel(EnglishLevel englishLevel);
}
