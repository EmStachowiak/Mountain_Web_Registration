package pl.maja.service;

import org.springframework.stereotype.Service;
import pl.maja.model.User;
import pl.maja.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(String nickName) {
        return this.userRepository.findByNickName(nickName);
    }


}
