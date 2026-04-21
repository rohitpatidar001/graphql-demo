package com.demo.graphql.controller;

import com.demo.graphql.model.User;
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
    public List<User> users() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User userById(@Argument String id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        return userService.createUser(name, email);
    }
}
