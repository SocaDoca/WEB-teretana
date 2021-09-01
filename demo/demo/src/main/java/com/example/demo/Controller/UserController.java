package com.example.demo.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.DTO.*;
import com.example.demo.Model.*;
import com.example.demo.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GymService gymService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private DoneTrainingsService doneTrainService;



    @GetMapping("/register")
    public String register(){
        return "register.html";
    }

    @PostMapping("/register-user")
    public ResponseEntity<?> register_user(@RequestBody User user) {
        List<User> verifyUser = new ArrayList<>();
        User user1;
        try {
            user1=userService.save(user);
            verifyUser.add(user1);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<User>(user1, HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public String account(@PathVariable(name = "id") Long id, Model model) {
        User user=this.userService.findOne(id);
        model.addAttribute("user", user);
        return "account.html";
    }
    @GetMapping("/account/{id}/done_trainings")
    public String done_trainings(@PathVariable(name = "id") Long id,Model model) {
        User user=this.userService.findOne(id);
        List<DoneTraining> trainingAll =this.doneTrainService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("done_training", trainingAll);
        return "done_trainings.html";
    }

    @GetMapping("/getAllDoneTrainings")
    public ResponseEntity<?> getDoneTrainings(){
        try {
            List<DoneTraining> trainingAll =this.doneTrainService.findAll();
            return new ResponseEntity<>(trainingAll,HttpStatus.OK);
            }
        catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.CONFLICT);
        }

    }


    @GetMapping("/account/{id}/reservations")
    public String reservations(@PathVariable(name = "id") Long id,Model model) {
        User user=this.userService.findOne(id);
        List<Schedule> schedules = this.scheduleService.findAll();
        model.addAttribute("user", user);
        return "reservations.html";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        User user;
        try {
            user=this.userService.checkEmail(userDTO);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        if(user==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!(this.userService.login(userDTO, user))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(user.getActive() == false) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/rate")
    public ResponseEntity<?> rate(@RequestBody RatingDTO ratingDTO){
        try{
            this.userService.RateIt(ratingDTO.getRating(), ratingDTO.getTraining_id(),ratingDTO.getDone_training_id());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/cancel_reservation")
    public ResponseEntity<?> cancel(@RequestBody ReservationDTO reservationDTO){
        try {
            this.userService.cancelReservation(reservationDTO.getMember_id(),reservationDTO.getSchedule_id());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/account/{id}/trainers")
    public String trainers(@PathVariable(name = "id") Long id,Model model) {
        List<User> members=this.userService.getTrainers();
        User user=this.userService.findOne(id);
        model.addAttribute("trainersObj", members);
        model.addAttribute("user",user);
        return "trainers.html";
    }

    @GetMapping("/account/{id}/register_trainer")
    public String register_trainer(@PathVariable(name = "id") Long id,Model model) {
        List<Gym> gyms=this.gymService.findAll();
        User user=this.userService.findOne(id);
        model.addAttribute("gyms", gyms);
        model.addAttribute("user",user);
        return "register_trainer.html";
    }

    @DeleteMapping("/remove_trainer/{id}")
    public ResponseEntity<?> remove_trainer(@PathVariable(name = "id") Long id) {
        try{
            this.userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/create_trainer")
    public ResponseEntity<?> create_trainer(@RequestBody TrainerDTO trainerDTO) {
        try {
            this.userService.saveTrainer(trainerDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reserve_training")
    public ResponseEntity<?> reserve_training(@RequestBody ReservationDTO reservationDTO){
        boolean flag=false;
        try {
            flag=this.userService.addReservation(reservationDTO.getMember_id(),reservationDTO.getSchedule_id());
            if(flag)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/account/{id}/gym")
    public String trainer_gym(@PathVariable(name = "id") Long id,Model model) {
        User user=this.userService.findOne(id);
        Gym gym=user.getGym();
        model.addAttribute("gym", gym);
        model.addAttribute("user",user);
        return "admin_gym.html";
    }

    @GetMapping("/rooms")
    public String room (Model model) {
        List<Room> rooms = this.roomService.findAll();
        List<Gym> gyms = this.gymService.findAll();
        model.addAttribute("rooms" , rooms);
        model.addAttribute("gyms" , gyms    );
        return "rooms.html";
    }

    @DeleteMapping("/delete_room/{gym_id}/room/{room_id}")
    public ResponseEntity<?> delete_room(@PathVariable(name = "gym_id") Long cinema_id,@PathVariable(name = "room_id") Long room_id) {
        try{
            if(this.roomService.deleteById(cinema_id,room_id))
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add_room")
    public ResponseEntity<?> add_room(@RequestBody RoomDTO room) {
        try {
            userService.addRoom(room);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/edit_room")
    public ResponseEntity<?> edit_room(@RequestBody Room room){
        try{
            this.userService.editRoom(room);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/account/{id}/gym/room/{room_id}")
    public String room_editing(@PathVariable(name = "id") Long id,@PathVariable(name = "room_id") Long room_id,Model model) {
        Room room=this.roomService.findOne(room_id);
        model.addAttribute("room", room);
        return "room.html";
    }
    @GetMapping("/account/{id}/schedule")
    public String schedule(@PathVariable(name="id")Long id,Model model) {
        User user=this.userService.findOne(id);
        Gym gym = user.getGym();
        List<Gym>gyms = this.gymService.findAll();
        List<Training> trainings=this.trainingService.findAll();
        List<Schedule> schedules = this.scheduleService.findAll();
        List<Room> rooms = this.roomService.findAll();
        model.addAttribute("room", rooms);
        model.addAttribute("user", user);
        model.addAttribute("gym", gym);
        model.addAttribute("gyms", gyms);
        model.addAttribute("trainings", trainings);
        model.addAttribute("schedules", schedules);

        return "schedule.html";
    }


    @GetMapping("/scheduleALL")
    public ResponseEntity scheduleALL(){
        try {
            List<Schedule> scheduleDTO = this.scheduleService.findAll();
            return new ResponseEntity(scheduleDTO, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e, HttpStatus.CONFLICT);
        }
    }
    @PostMapping("/add_schedule")
    public ResponseEntity<?> add_schedule(@RequestBody ScheduleDTO scheduleDTO) {
        try {

            this.scheduleService.addProjection(scheduleDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e,HttpStatus.CONFLICT);
        }

    }


    @GetMapping("/account/{id}/verify")
    public ResponseEntity<?> verifyUser(@PathVariable(name = "id") Long id){
        User user=this.userService.findOne(id);
        if(user.getActive() == false) {
            user.setActive(true);
            if (this.userService.save(user) != null) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
