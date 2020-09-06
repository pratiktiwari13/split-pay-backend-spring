package spring.splitpayspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.splitpayspring.models.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {
     Users findUsersByToken(String token);
     Users findUsersByUserEmail(String userEmail);
     Users findUsersByUsername(String username);
}
