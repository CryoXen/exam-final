package edu.mx.utvt.examenfinal.repos;

import edu.mx.utvt.examenfinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
