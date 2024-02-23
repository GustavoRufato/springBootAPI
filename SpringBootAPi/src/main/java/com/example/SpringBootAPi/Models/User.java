package com.example.SpringBootAPi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = User.TABLE_NAME)
public class User {
    private static final String TABLE_NAME = "users";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    
    @NotBlank
    @Size(min = 2, max = 100)
    @Column(name = "user_name", length = 100, nullable = false, unique = true)
    private String username;

    @NotBlank
    @Size(min = 8, max = 60)
    @Column(name = "user_password", length = 60, nullable = false)
    private String password;

    
    
    public User(@NotBlank @Size(min = 2, max = 100) String username,
            @NotBlank @Size(min = 8, max = 60) String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    }

