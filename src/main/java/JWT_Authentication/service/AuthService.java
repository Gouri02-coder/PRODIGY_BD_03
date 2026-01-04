package JWT_Authentication.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import JWT_Authentication.dto.LoginRequest;
import JWT_Authentication.dto.RegisterRequest;
import JWT_Authentication.model.Role;
import JWT_Authentication.model.User;
import JWT_Authentication.repository.UserRepository;
import JWT_Authentication.security.JwtUtil;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repository,
                       PasswordEncoder encoder,
                       JwtUtil jwtUtil) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public void register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);
        repository.save(user);
    }

    public String login(LoginRequest request) {
        User user = repository.findByEmail(request.getEmail()).orElseThrow();

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user);
    }
}
