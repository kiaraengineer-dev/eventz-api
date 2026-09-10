package com.eventz.eventz_api.service;

import org.springframework.stereotype.Service;
import com.eventz.eventz_api.entity.User;
import com.eventz.eventz_api.repository.UserRepository;
import com.eventz.eventz_api.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.eventz.eventz_api.dto.LoginRequest;
import com.eventz.eventz_api.dto.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    
    public String register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
        return "Email Já cadastrado.";
    
    }

    if(userRepository.existsByCpf(request.getCpf())) {
        return "CPF já cadastrado.";
    }

    if(!request.getPassword().equals(request.getConfirmPassword())) {
        return "As senhas não coincidem.";
    }

    User user = new User();

    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setCpf(request.getCpf());
    user.setPhone(request.getPhone());

    user.setPassword(passwordEncoder.encode(request.getPassword()));

    userRepository.save(user);
    return "Cadastro realizado com sucesso.";
    }


   public LoginResponse login(LoginRequest request) {

    Optional<User> user = userRepository.findByEmail(request.getEmail());

    if (user.isEmpty()) {
        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "E-mail ou senha inválidos."
        );
    }

    boolean senhaCorreta = passwordEncoder.matches(
            request.getPassword(),
            user.get().getPassword()
    );

    if (!senhaCorreta) {
        throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "E-mail ou senha inválidos."
        );
    }

    String token = jwtService.generateToken(user.get().getEmail());

    return new LoginResponse(token, "Bearer");
}

}
