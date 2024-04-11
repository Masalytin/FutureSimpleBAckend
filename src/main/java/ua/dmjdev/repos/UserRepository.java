package ua.dmjdev.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.dmjdev.models.usr.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
