package com.firstspringproject.spring.boot.crud.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringproject.spring.boot.crud.app.entitiy.User;
import com.firstspringproject.spring.boot.crud.app.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> usrs = userRepository.getAllActiveUsers("Active");
        if (usrs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(usrs);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Integer id) {
        try {
            Optional<User> u = userRepository.findByIdAndStatus(id, "Active");
            if (u.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User usr) {
        try {
            return ResponseEntity.ok().body(userRepository.save(usr));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        }

    }

}
