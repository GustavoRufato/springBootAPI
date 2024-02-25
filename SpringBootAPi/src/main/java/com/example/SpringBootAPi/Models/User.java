package com.example.SpringBootAPi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public interface CreateUser {}
    public interface UpdateUser {}

    private static final String TABLE_NAME = "users";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;
    
    
    @Size(groups = CreateUser.class, min = 2, max = 100)
    @Column(name = "user_name", length = 100, nullable = false, unique = true)
    @NotBlank(groups = CreateUser.class)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @NotBlank(groups = {CreateUser.class, UpdateUser.class})
    @Size(groups = {CreateUser.class, UpdateUser.class}, min = 8, max = 60)
    @Column(name = "user_password", length = 60, nullable = false)
    private String password;

    
    
    public User(Long id, String username,String password) {
        
        this.id = id; 
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

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;    
        result = prime + result + ((this.id == null)? 0 : this.id.hashCode());
        return result;
    }   

    @Override
    public boolean equals(Object obj){
        if (obj == this) 
            return true;
        if (obj == null) 
            return false;   
        if (!(obj instanceof User)) 
            return false;
        User other = (User) obj;
        if (this.id == null) 
            if (other.id != null) 
                return false;
            else if(!this.id.equals(other.id))
                return false;
        return Objects.equals(this.id, other.id) 
            && Objects.equals(this.username, other.username) 
            && Objects.equals(this.password, other.password);
    }

}

