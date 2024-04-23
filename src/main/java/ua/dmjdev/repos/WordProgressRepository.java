package ua.dmjdev.repos;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.dictionary.WordProgress;
import ua.dmjdev.models.usr.User;

import java.util.List;

@Repository
public interface WordProgressRepository extends JpaRepository<WordProgress, Long> {
    WordProgress findByUserAndWordName(User user, String wordName);
    boolean existsByUserAndWordName(User user, String wordName);
    List<WordProgress> findByUserOrderByCreationDateDesc(User user, Pageable pageable);
    default List<WordProgress> getPageByUser(User user, int page, int pageSize) {
        return findByUserOrderByCreationDateDesc(user, PageRequest.of(page, pageSize));
    }
}
