//static values used, assure that the mentioned ids are present in the db

package spring.splitpayspring.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.splitpayspring.models.Expenses;
import spring.splitpayspring.models.Users;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpensesRepositoryTest {

    @Autowired
    ExpensesRepository expensesRepository;

    @Autowired
    UsersRepository usersRepository;

    Users user1;
    Users user2;
    Expenses expense;

    @Before
    public void setup(){
        user1 = new Users();
        user1.setUsername("abcd");
        user1.setToken("token");
        user1.setUserEmail("abcd@example.com");
        user1 = usersRepository.save(user1);

        user2 = new Users();
        user2.setUsername("pqrs");
        user2.setToken("token2");
        user2.setUserEmail("pqrs@example.com");
        user2 = usersRepository.save(user2);

        expense = new Expenses();
        expense.setAmount(1000L);
        expense.setToUserId(user1);
        expense.setFromUserId(user2);
        expense.setIsPaid(false);
        expense.setIsOwing(true);
        expense.setDescription("Test");

    }

    @Test
    public void whenFindByToAndFrom_returnExpenses(){
        expensesRepository.save(expense);
        List<Expenses> expenses = expensesRepository.findExpensesByFromUserIdAndToUserId(user1,user2);
        for (Expenses e : expenses) {
            assertThat(e.getFromUserId()).isEqualTo(user1);
            assertThat(e.getToUserId()).isEqualTo(user2);
        }
    }

    @Test
    public void whenGivenMyUserID_returnUsersWhoOweMe(){
        Users user = usersRepository.getOne(267L);
        List<Object[]> objects = expensesRepository.findUsersWhoOweMe(user);
        assertThat(objects.get(0).length).isEqualTo(3);
    }

    @Test
    public void whenGivenMyUserId_returnUsersIOweTo(){
        Users user = usersRepository.getOne(268L);
        List<Object[]> objects = expensesRepository.findUsersIOweTo(user);
        assertThat(objects.get(0).length).isEqualTo(3);
    }

    @Test
    public void whenGivenMyUserId_returnTotalOwes(){
        Users user = usersRepository.getOne(289L);
        int total = expensesRepository.findOwedTotal(user);
        assertThat(total).isEqualTo(2000);
    }

    @Test
    public void whenGivenMyUserId_returnTotalOwed(){
        Users user = usersRepository.getOne(288L);
        int total = expensesRepository.findOwingTotal(user);
        assertThat(total).isEqualTo(2000);
    }

    @Test
    public void whenGivenMyUserId_returnTotalPersonalExpenses(){
        Users user = usersRepository.getOne(326L);
        int total = expensesRepository.findPersonalExpensesTotal(user);
        assertThat(total).isEqualTo(2000);
    }

    @Test
    public void whenGivenMyUserId_returnAllOfMyExpenses(){
        Users user = usersRepository.getOne(326L);
        List<Object[]> personalExpenses = expensesRepository.findAllPersonalExpenses(user);
        assertThat(personalExpenses).isNotNull();
    }
}


