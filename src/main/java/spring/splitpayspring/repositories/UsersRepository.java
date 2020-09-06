package spring.splitpayspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.splitpayspring.models.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long> {
     List<Users> findUsersByToken(String token);
     List<Users> findUsersByUserEmail(String userEmail);
     List<Users> findUsersByUsername(String username);
}
