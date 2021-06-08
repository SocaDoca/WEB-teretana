package com.example.demo.Repository;

import com.example.demo.Model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrainingRepository extends JpaRepository<Training,Long> {
    @Modifying
    @Query("update Training  set rating = :rating WHERE id = :trainingId")
    void setRating(@Param("trainingId") Long id, @Param("rating") long rating);
}
