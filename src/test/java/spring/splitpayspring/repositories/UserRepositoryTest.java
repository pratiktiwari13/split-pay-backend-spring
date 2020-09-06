//static values used, assure that the mentioned ids are present in the db
package spring.splitpayspring.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.splitpayspring.models.Users;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UsersRepository usersRepository;
    @Before
    public void setup(){
        Users u = new Users();
        u.setUsername("username");
        u.setUserEmail("username@mail.com");
        u.setToken("token-username");
        usersRepository.save(u);
    }

    @Test
    public void whenGivenEmail_returnUser(){
        List<Users> u = usersRepository.findUsersByUserEmail("username@mail.com");
        assertThat(u).isNotNull();
    }

    @Test
    public void whenGivenToken_returnUser(){
        List<Users> u = usersRepository.findUsersByToken("token-username");
        assertThat(u).isNotNull();
    }

    @Test
    public void whenGivenUsername_returnUser(){
        List<Users> u = usersRepository.findUsersByUsername("username");
        assertThat(u).isNotNull();
    }
}
