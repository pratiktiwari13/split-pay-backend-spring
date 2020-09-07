package spring.splitpayspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.splitpayspring.models.Users;
import spring.splitpayspring.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersService {

    final UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void createUser(String username,String userEmail, String token) throws IllegalStateException{
        if(userExists(userEmail)){
            throw new IllegalStateException("Username already exists");
        }
        Users u = new Users();
        u.setUserEmail(userEmail);
        u.setUsername(username);
        u.setToken(token);
        usersRepository.save(u);
    }

    public Users getUserByToken(String token){
        List<Users> users = usersRepository.findUsersByToken(token);
        if(users.size()>0)
            return users.get(0);
        return null;
    }

    public boolean userExists(String email){
        return usersRepository.findUsersByUserEmail(email).size() != 0;
    }

    public Users getUserByEmail(String email){
        List<Users> users = usersRepository.findUsersByUserEmail(email);
        if(users.size()>0)
            return users.get(0);
        return null;
    }

    public Users getUserByUsername(String username){
        List<Users> users = usersRepository.findUsersByUsername(username);
        if(users.size()>0)
            return users.get(0);
        return null;
    }
}
