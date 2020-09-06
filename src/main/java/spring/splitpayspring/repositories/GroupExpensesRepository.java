package spring.splitpayspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.splitpayspring.models.GroupExpenses;

public interface GroupExpensesRepository extends JpaRepository<GroupExpenses,Long> {
}
