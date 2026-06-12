package com.smartrent.api.controller;

import com.smartrent.api.dto.LoginDTO;
import com.smartrent.api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@Valid @RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return Map.of("token", token);
    }
}