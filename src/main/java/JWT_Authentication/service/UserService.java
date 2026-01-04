package JWT_Authentication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import JWT_Authentication.model.User;
import JWT_Authentication.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow();
    }
}
