package com.matematikaceria.backend.controller;

import com.matematikaceria.backend.entity.User;
import com.matematikaceria.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*") // supaya bisa diakses dari Android/FE
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        var data = userService.findByUsername(user.getUsername());
        if (data.isPresent() && data.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(data.get());
        } else {
            return ResponseEntity.status(401).body("Username atau password salah");
        }
    }
}
