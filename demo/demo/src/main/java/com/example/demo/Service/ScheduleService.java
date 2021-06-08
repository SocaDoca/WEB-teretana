package com.example.demo.Service;

import com.example.demo.DTO.ScheduleDTO;
import com.example.demo.Model.Gym;
import com.example.demo.Model.Room;
import com.example.demo.Model.Schedule;
import com.example.demo.Model.Training;
import com.example.demo.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private GymService gymService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private RoomService roomService;

    public Schedule findOne(Long id) {
        Schedule schedule=this.scheduleRepository.findById(id).get();
        return schedule;
    }

    public List<Schedule> findAll(){
        List<Schedule> schedules=this.scheduleRepository.findAll();
        return schedules;
    }
    public Schedule save(Schedule schedule) {
        return this.scheduleRepository.save(schedule);
    }

    public List<Schedule> findByGymId(Long id)
    {
        return scheduleRepository.findByGymId(id);
    }

    public void addProjection(ScheduleDTO scheduleDTO) {
        Schedule schedule=new Schedule();
        Gym gym=this.gymService.findOne(scheduleDTO.getGym_id());
        Training training=this.trainingService.findOne(scheduleDTO.getTraining_id());
        Room room=this.roomService.findOne(scheduleDTO.getRoom_id());
        schedule.setGym(gym);
        schedule.setTraining(training);
        schedule.getRooms().add(room);
        schedule.setDay(scheduleDTO.getDay());
        schedule.setPrice(scheduleDTO.getPrice());
        schedule.setTime(scheduleDTO.getTime());
        schedule.setMembers(null);

        gym.getSchedule().add(schedule);
        room.getSchedules().add(schedule);
        this.scheduleRepository.save(schedule);

    }
}
