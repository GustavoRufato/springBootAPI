package com.example.SpringBootAPi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootAPi.Models.User;
import com.example.SpringBootAPi.Repositories.userRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
public class userService {
    
    @Autowired
    private userRepository userrepository;

        

    public User getUserById(Long id) {
        Optional<User> user = this.userrepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
            "Usuario Não encontrado! Id: " + id + ", Tipo: " + User.class.getName()       
        ));
     }

    @Transactional
    public User createUser(User obj){
        obj.setId(null);
        obj= this.userrepository.save(obj);
        return obj;
    }
    @Transactional
    public User updateUser(User obj) {
        User newObj= getUserById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userrepository.save(newObj);
    }

    public void deleteUser(Long id) {
        getUserById(id);
        try {
            this.userrepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir, pois há entidades relacionados");
            
        }
    }
}
