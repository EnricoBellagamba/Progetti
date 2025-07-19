package com.example.unittest.controller;

import com.example.unittest.entity.User;
import com.example.unittest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable Integer id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(optionalUser.get());
        }
    }



}
