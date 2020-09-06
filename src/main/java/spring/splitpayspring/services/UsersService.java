package spring.splitpayspring.services;

import org.springframework.stereotype.Service;
import spring.splitpayspring.models.Users;
import spring.splitpayspring.repositories.UsersRepository;

@Service
public class UsersService {

    final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void createUser(String username,String userEmail, String token){
        Users u = new Users();
        u.setUserEmail(userEmail);
        u.setUsername(username);
        u.setToken(token);
        usersRepository.save(u);
    }

    public Users getUserByToken(String token){
        return usersRepository.findUsersByToken(token);
    }

    public Users getUserByEmail(String email){
        return usersRepository.findUsersByUserEmail(email);
    }

    public Users getUserByUsername(String username){
        return usersRepository.findUsersByUsername(username);
    }
}
