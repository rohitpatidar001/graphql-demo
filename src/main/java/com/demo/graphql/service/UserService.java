package com.demo.graphql.service;

import com.demo.graphql.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<String, User> db = new HashMap<>();

    public List<User> getAllUsers() {
        return new ArrayList<>(db.values());
    }

    public User getUserById(String id) {
        return db.get(id);
    }

    public User createUser(String name, String email) {
        String id = UUID.randomUUID().toString();
        User user = new User(id, name, email);
        db.put(id, user);
        return user;
    }
}
