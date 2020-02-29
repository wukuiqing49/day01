package com.wu.day01.controller;

import com.wu.day01.entity.User;
import com.wu.day01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {


        return userRepository.findById(id).get();
    }

    @GetMapping("/user/findUser")
    public User findUSer(@RequestParam("id") Integer id) {


        return userRepository.findById(id).get();
    }

    @GetMapping("/user/loadAll")
    public List<User> loadAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
