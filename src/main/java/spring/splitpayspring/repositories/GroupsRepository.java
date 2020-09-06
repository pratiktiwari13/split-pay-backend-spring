package spring.splitpayspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.splitpayspring.models.Groups;

public interface GroupsRepository extends JpaRepository<Groups,Long> {
}
