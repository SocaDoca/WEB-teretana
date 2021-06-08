package com.example.demo.Repository;

import com.example.demo.Model.DoneTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoneTrainingRepository extends JpaRepository<DoneTraining,Long> {


    List<DoneTraining> findByTrainingId(Long id);

    @Modifying
    @Query ("update DoneTraining  set rating = :rating WHERE id = :Id")
    void setRating(@Param("Id") Long id, @Param("rating") long rating);
}
