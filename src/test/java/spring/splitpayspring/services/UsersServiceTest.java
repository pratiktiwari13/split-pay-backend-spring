package spring.splitpayspring.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.splitpayspring.models.Users;
import spring.splitpayspring.repositories.UsersRepository;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {
    @Mock
    UsersRepository usersRepository;

    @Spy
    @InjectMocks
    UsersService usersService;

    @Test
    public void whenGivenValidUserDetails_createUser(){
        Mockito.doReturn(false).when(usersService).userExists(Mockito.anyString());
        Mockito.when(usersRepository.save(Mockito.any(Users.class))).thenReturn(Mockito.any(Users.class));
        usersService.createUser("abc",Mockito.eq("abc@example.com"),Mockito.eq("user-token"));
    }

    @Test(expected = IllegalStateException.class)
    public void whenGivenExistingUser_throwException(){
        Mockito.doReturn(true).when(usersService).userExists(Mockito.anyString());
        usersService.createUser("username","username@example.com","token-abc");
    }

    @Test
    public void whenGivenUsername_returnUser(){
        ArrayList<Users> sampleArrayListOfUsers=new ArrayList<>(1);
        sampleArrayListOfUsers.add(new Users());
        Mockito.when(usersRepository.findUsersByUsername(Mockito.anyString())).thenReturn(sampleArrayListOfUsers);
        Users u = usersService.getUserByUsername("somename");
        assertThat(u).isNotNull();
    }

    @Test
    public void whenGivenInvalidUsername_returnNull(){
        Mockito.when(usersRepository.findUsersByUsername(Mockito.anyString())).thenReturn(Mockito.anyList()); //anyList returns a list of size 0 so it successfully fails the test
        Users u = usersService.getUserByUsername("somename");
        assertThat(u).isNull();
    }

    @Test
    public void whenGivenEmail_returnUser(){
        ArrayList<Users> sampleArrayListOfUsers=new ArrayList<>(1);
        sampleArrayListOfUsers.add(new Users());
        Mockito.when(usersRepository.findUsersByUserEmail(Mockito.anyString())).thenReturn(sampleArrayListOfUsers);
        Users u = usersService.getUserByEmail("some@mail.com");
        assertThat(u).isNotNull();
    }

    @Test
    public void whenGivenInvalidEmail_returnNull(){
        Mockito.when(usersRepository.findUsersByUserEmail(Mockito.anyString())).thenReturn(Mockito.anyList()); //anyList returns a list of size 0 so it successfully fails the test
        Users u = usersService.getUserByEmail("some@mail.com");
        assertThat(u).isNull();
    }

    @Test
    public void whenGivenToken_returnUser(){
        ArrayList<Users> sampleArrayListOfUsers=new ArrayList<>(1);
        sampleArrayListOfUsers.add(new Users());
        Mockito.when(usersRepository.findUsersByToken(Mockito.anyString())).thenReturn(sampleArrayListOfUsers);
        Users u = usersService.getUserByToken("some-token");
        assertThat(u).isNotNull();
    }

    @Test
    public void whenGivenInvalidToken_returnNull(){
        Mockito.when(usersRepository.findUsersByToken(Mockito.anyString())).thenReturn(Mockito.anyList()); //anyList returns a list of size 0 so it successfully fails the test
        Users u = usersService.getUserByToken("some-token");
        assertThat(u).isNull();
    }
}
