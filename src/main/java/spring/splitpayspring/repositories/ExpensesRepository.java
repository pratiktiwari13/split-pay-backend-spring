package spring.splitpayspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.splitpayspring.models.Expenses;
import spring.splitpayspring.models.Users;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
    List<Expenses> findExpensesByFromUserIdAndToUserId(Users fromUserId, Users toUserId);

    @Query(value = "select u.username,u.userEmail,fe.amount from Users u join u.fromExpenses fe join fe.fromUserId fuid where fuid= :me and fe.isPaid=false")
    List<Object[]> findUsersIOweTo(@Param("me") Users me);

    @Query(value = "select u.username,u.userEmail,te.amount from Users u join u.toExpenses te join te.toUserId tuid where tuid= :me and te.isPaid=false")
    List<Object[]> findUsersWhoOweMe(@Param("me") Users me);

    @Query(value = "Select fe.amount from Users u join u.fromExpenses fe join fe.fromUserId fuid join fe.toUserId tuid where fuid=:me and tuid=:me and fe.isPaid = false")
    List<Object[]> findAllPersonalExpenses(@Param("me") Users me);

    @Query(value = "select sum(fe.amount) from Users u join u.fromExpenses fe join fe.fromUserId fuid where fuid=:me and fe.isPaid=false")
    int findOwedTotal(@Param("me") Users me);

    @Query(value = "select sum(te.amount) from Users u join u.toExpenses te join te.toUserId tuid where tuid=:me and te.isPaid=false")
    int findOwingTotal(@Param("me") Users me);

    @Query(value = "Select sum(fe.amount) from Users u join u.fromExpenses fe join fe.fromUserId fuid join fe.toUserId tuid where fuid=:me and tuid=:me and fe.isPaid = false")
    int findPersonalExpensesTotal(@Param("me") Users me);
}
