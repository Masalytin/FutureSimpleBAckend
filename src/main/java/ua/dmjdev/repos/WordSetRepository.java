package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.dictionary.WordsSet;

@Repository
public interface WordSetRepository extends JpaRepository<WordsSet, Integer> {
}
