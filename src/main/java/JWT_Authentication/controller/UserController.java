package JWT_Authentication.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import JWT_Authentication.model.User;
import JWT_Authentication.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/profile")
    public String profile() {
        return "Authenticated user";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<User> allUsers() {
        return service.getAllUsers();
    }
}
