package com.example.demo.Repository;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    List<User> findByRole(Role role);
/*
    @Query ("update User  set username = :username, set password WHERE id = :Id")
    void updateUser(@Param("Id") Long id, @Param("rating") long rating);*/
}
