package com.demo.graphql.service;

import com.demo.graphql.dto.UserDTO;
import com.demo.graphql.model.UserEntity;
import com.demo.graphql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserDTO getUserById(String id) {
        UserEntity user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public List<UserDTO> getUsers() {
        return repo.findAll().stream()
                .map(u -> new UserDTO(u.getId(), u.getName(), u.getEmail()))
                .toList();
    }

    public UserDTO createUser(String name, String email) {
        String id = UUID.randomUUID().toString();

        UserEntity entity = new UserEntity(id, name, email);
        repo.save(entity);

        return new UserDTO(id, name, email);
    }
}
