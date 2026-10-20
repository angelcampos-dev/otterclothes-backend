package com.otterclothes.api.controllers;

import com.otterclothes.api.models.User;
import com.otterclothes.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("user_email");
        String password = credentials.get("user_password");

        Optional<User> userOptional = userRepository.findByUserEmail(email);

        if (userOptional.isPresent() && userOptional.get().getUserPassword().equals(password)) {
            return ResponseEntity.ok(userOptional.get());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Correo o contraseña incorrectos"));
    }
}