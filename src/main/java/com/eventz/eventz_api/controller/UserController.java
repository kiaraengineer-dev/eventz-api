package com.eventz.eventz_api.controller;

import com.eventz.eventz_api.entity.User;
import com.eventz.eventz_api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.eventz.eventz_api.dto.UserResponseDTO;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

@GetMapping("/me")

public UserResponseDTO me(Authentication authentication) {

    String email = authentication.getName();

    User user = userRepository
            .findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    return new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getCpf(),
            user.getPhone()
    );
}
}