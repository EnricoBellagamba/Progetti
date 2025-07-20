package com.example.unittest.controller;

import com.example.unittest.entity.User;
import com.example.unittest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllStudents() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody User getStudent(@PathVariable("id") Integer id) {
        Optional<User> student = userRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            return null;
        }
    }

    @PostMapping
    public @ResponseBody User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public @ResponseBody User update(@PathVariable("id") Integer id,
                                        @RequestBody User updatedUser) {
        Optional<User> existingUserOpt = userRepository.findById(id);

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();


            existingUser.setName(updatedUser.getName());
            existingUser.setSurname(updatedUser.getSurname());
            existingUser.setAge(updatedUser.getAge());


            if (updatedUser.getId() != id) {
                userRepository.deleteById(id);
                return userRepository.save(updatedUser);
            } else {
                return userRepository.save(updatedUser);
            }
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}
