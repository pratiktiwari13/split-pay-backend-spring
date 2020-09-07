package spring.splitpayspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.splitpayspring.models.GroupExpenses;
import spring.splitpayspring.models.Groups;

import java.util.List;

public interface GroupExpensesRepository extends JpaRepository<GroupExpenses,Long> {
    List<GroupExpenses> findGroupExpensesByGroups(Groups group);
}
