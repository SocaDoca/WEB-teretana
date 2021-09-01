package com.example.demo.Repository;

import com.example.demo.Model.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GymRepository extends JpaRepository<Gym,Long> {

    @Modifying
    @Query("update Gym set name = :name, address = :address , phone_number = :phoneNum , email = :email WHERE id = :Id")
    void updateGym(@Param("Id") Long id , @Param("name") String name, @Param("address") String address , @Param("phoneNum") String phoneNum , @Param("email") String email);
}
