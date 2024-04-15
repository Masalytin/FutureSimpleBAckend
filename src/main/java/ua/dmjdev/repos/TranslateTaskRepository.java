package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.dmjdev.dto.Rule;
import ua.dmjdev.models.tasks.TranslateTask;

@Repository
public interface TranslateTaskRepository extends JpaRepository<TranslateTask, Long> {
    @Query(value = "SELECT * FROM translate_tasks WHERE rule = :rule ORDER BY RAND() LIMIT 1", nativeQuery = true)
    TranslateTask findRandomByRule(Rule rule);
}
