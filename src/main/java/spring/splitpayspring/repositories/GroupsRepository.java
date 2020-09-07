package spring.splitpayspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.splitpayspring.models.Groups;
import spring.splitpayspring.models.Users;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Groups,Long> {
    List<Groups> findGroupsByUsersContaining(Users me);
}
