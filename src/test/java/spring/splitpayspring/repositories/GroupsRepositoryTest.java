package spring.splitpayspring.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.splitpayspring.models.Groups;
import spring.splitpayspring.models.Users;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupsRepositoryTest {
    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void whenGivenUser_returnAllGroups(){
        Users user = usersRepository.getOne(267L);
        List<Groups> groups = groupsRepository.findGroupsByUsersContaining(user);
        for(Groups group : groups){
            System.out.println(group.getGroup_id());
        }
    }

    @Test
    public void whenGivenGroupId_returnGroup(){
        Groups g = groupsRepository.findById(1L).get();
        System.out.println(g.getGroup_id());
    }
}
