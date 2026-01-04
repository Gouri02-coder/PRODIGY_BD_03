package JWT_Authentication.controller;

import org.springframework.web.bind.annotation.*;

import JWT_Authentication.dto.AuthResponse;
import JWT_Authentication.dto.LoginRequest;
import JWT_Authentication.dto.RegisterRequest;
import JWT_Authentication.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        service.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return new AuthResponse(service.login(request));
    }
}
