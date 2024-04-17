package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.dictionary.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    public Word findByName(String name);
}
