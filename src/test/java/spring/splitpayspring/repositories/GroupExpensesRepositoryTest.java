package spring.splitpayspring.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.splitpayspring.models.GroupExpenses;
import spring.splitpayspring.models.Groups;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupExpensesRepositoryTest {
    @Autowired
    GroupExpensesRepository groupExpensesRepository;

    @Autowired
    GroupsRepository groupsRepository;
    @Test
    public void whenGivenGroup_returnGroupExpenses(){
        Groups group = groupsRepository.findById(1L).get();
        List<GroupExpenses> groupExpenses = groupExpensesRepository.findGroupExpensesByGroups(group);
        assertThat(groupExpenses).isNotNull();
    }
}
