package com.example.demo.Repository;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    List<User> findByRole(Role role);
}
