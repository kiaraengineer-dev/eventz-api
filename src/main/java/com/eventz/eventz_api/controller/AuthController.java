package com.eventz.eventz_api.controller;

import com.eventz.eventz_api.dto.LoginRequest;
import com.eventz.eventz_api.dto.LoginResponse;
import com.eventz.eventz_api.dto.RegisterRequest;
import com.eventz.eventz_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

    return authService.login(request);

    }

    @GetMapping("/teste")
public String teste() {
    return "Você chegou até o endpoint!";
}

}



