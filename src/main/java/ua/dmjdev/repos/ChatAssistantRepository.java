package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.assistent.ChatAssistant;

@Repository
public interface ChatAssistantRepository extends JpaRepository<ChatAssistant, Long> {

}
