package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.TranslateTask;

@Repository
public interface TranslateTaskRepository extends JpaRepository<TranslateTask, Long> {

}
