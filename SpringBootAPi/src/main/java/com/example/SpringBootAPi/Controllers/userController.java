package com.example.SpringBootAPi.Controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.SpringBootAPi.Models.User;
import com.example.SpringBootAPi.Models.User.CreateUser;
import com.example.SpringBootAPi.Models.User.UpdateUser;

import com.example.SpringBootAPi.Services.userService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class userController{
    @Autowired
    private userService userservice;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = this.userservice.getUserById(id);
        return ResponseEntity.ok().body(obj);     
    }

    @PostMapping
    @Validated(CreateUser.class)
    public ResponseEntity<Void> create(@Valid @RequestBody User obj){
        this.userservice.createUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(UpdateUser.class)
    public ResponseEntity<Void> update(@Valid @RequestBody User obj, @PathVariable Long id){
        obj.setId(id);
        this.userservice.updateUser(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Validated(UpdateUser.class)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.userservice.deleteUser(id);

        return ResponseEntity.noContent().build();
    }


}