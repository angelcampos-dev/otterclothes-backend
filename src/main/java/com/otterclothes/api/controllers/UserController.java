package com.otterclothes.api.controllers;

import com.otterclothes.api.models.User;
import com.otterclothes.api.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    // inyección del repositorio para usar el crud
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // crud raed para obtener todos los usuarios
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // crud cretae para guardar un nuevo usuario
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
