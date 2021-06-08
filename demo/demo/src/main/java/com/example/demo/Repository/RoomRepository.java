package com.example.demo.Repository;

import com.example.demo.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room,Long> {

    @Modifying
    @Query("update Room set mark = :mark, capacity=:capacity WHERE id = :Id")
    void updateRoom(@Param("Id") Long id, @Param("capacity") Long capacity,@Param("mark") String mark);
}
