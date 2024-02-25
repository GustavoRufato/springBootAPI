package com.example.SpringBootAPi.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootAPi.Models.User;


public interface userRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.id = :id ")
    List<User> findByUserId(@Param("id") Long id);

    //@Query(value = "SELECT * FROM User u WHERE u.user_id = :id, nativerQuery = true")
    //List<User> findByUser_Id(@Param("id") Long id);
    
}
