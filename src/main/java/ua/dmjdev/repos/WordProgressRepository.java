package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.dictionary.WordProgress;
import ua.dmjdev.models.usr.User;

@Repository
public interface WordProgressRepository extends JpaRepository<WordProgress, Long> {

    public WordProgress findByUserAndWordName(User user, String wordName);
}
