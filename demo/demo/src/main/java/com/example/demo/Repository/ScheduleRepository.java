package com.example.demo.Repository;

import com.example.demo.Model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    List<Schedule> findByGymId(Long id);
}
