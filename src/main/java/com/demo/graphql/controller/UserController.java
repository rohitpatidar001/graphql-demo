package com.demo.graphql.controller;

import com.demo.graphql.dto.UserDTO;
import com.demo.graphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @QueryMapping
    public List<UserDTO> users() {
        return userService.getUsers();
    }

    @QueryMapping
    public UserDTO userById(@Argument String id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public UserDTO createUser(@Argument String name, @Argument String email) {
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("Name cannot be empty");
        }

        if (email == null || !email.contains("@")) {
            throw new RuntimeException("Invalid email");
        }

        return userService.createUser(name, email);
    }
}
