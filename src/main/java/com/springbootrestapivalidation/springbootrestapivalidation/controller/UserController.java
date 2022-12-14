package com.springbootrestapivalidation.springbootrestapivalidation.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springbootrestapivalidation.springbootrestapivalidation.exception.UserNotFoundException;
import com.springbootrestapivalidation.springbootrestapivalidation.model.User;
import com.springbootrestapivalidation.springbootrestapivalidation.service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userService.getById(id);
        if (user == null) {
            throw new UserNotFoundException("user id - " + id + " not found");
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        User user = userService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("user id - " + id + " not found");
        }

    }

}
