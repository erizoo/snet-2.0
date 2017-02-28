package by.boiko.snet.config.repository;

import by.boiko.snet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
