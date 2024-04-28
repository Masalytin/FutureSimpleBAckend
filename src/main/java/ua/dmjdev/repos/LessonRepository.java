package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.lesons.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
