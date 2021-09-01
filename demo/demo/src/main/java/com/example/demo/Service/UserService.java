package com.example.demo.Service;

import com.example.demo.DTO.RoomDTO;
import com.example.demo.DTO.TrainerDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Model.*;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private DoneTrainingsService doneTrainingsService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private GymService gymService;

    @Autowired
    private RoomService roomService;

    public User findOne(Long id) {
        User user = this.userRepository.findById(id).get();
        return user;
    }

    public List<User> findAll() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public boolean login(UserDTO userDTO, User user) {
        if (user.getPassword().equals(userDTO.getPassword())) {
            return true;
        }
        return false;
    }

    public User checkEmail(UserDTO userDTO) {
        User user = this.userRepository.findByEmail(userDTO.getEmail());
        if (user == null)
            return null;
        return user;
    }

    public void RateIt(Long rating, Long training_id, Long done_training_id) {
        this.doneTrainingsService.setRating(done_training_id, rating);
        double avg = this.doneTrainingsService.calculateRating(training_id);
        this.trainingService.setRating(training_id, (long) avg);
        return;
    }

    public void cancelReservation(Long member_id, Long schedule_id) {

        User user = this.userRepository.findById(member_id).get();
        Schedule schedule = this.scheduleService.findOne(schedule_id);
        user.getReserved_training().remove(schedule);

        return;
    }

    public List<User> getTrainers() {
        return this.userRepository.findByRole(Role.TRAINER);
    }

    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);

    }

    public void saveTrainer(TrainerDTO trainerDTO) {
        Gym gym = gymService.findOne(trainerDTO.getGym_id());
        User user = new User(trainerDTO.getUsername(), trainerDTO.getPassword(), trainerDTO.getName(),
                trainerDTO.getSurname(), trainerDTO.getPhone_number(), trainerDTO.getEmail(), trainerDTO.getDate_of_birth(),
                trainerDTO.getRole(), trainerDTO.isActive(), gym, null, null);
        this.userRepository.save(user);
    }
    public boolean addReservation(Long member_id, Long schedule_id) {
        User user = this.userRepository.findById(member_id).get();
        Schedule schedule = this.scheduleService.findOne(schedule_id);
        if(user.getReserved_training().contains(schedule)) {
            return false;
        }

        for(Room room: schedule.getRooms()) {
            if(room.getCapacity()-schedule.getMembers().size()>0) {
                user.getReserved_training().add(schedule);
                return true;
            }

        }
        return false;
    }

    public void addRoom(RoomDTO roomDTO) {
        Gym gym=this.gymService.findOne(roomDTO.getGym_id());
        Room room=new Room(roomDTO.getCapacity(),roomDTO.getMark(),null,gym);
        this.roomService.save(room);
    }
    public void editRoom(Room room) {
        this.roomService.editRoom(room);
    }
}
