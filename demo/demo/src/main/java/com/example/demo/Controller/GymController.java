package com.example.demo.Controller;

import com.example.demo.DTO.GymDTO;
import com.example.demo.Model.Gym;
import com.example.demo.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class  GymController {

    @Autowired
    private GymService gymService;

    @GetMapping("/gyms")
    public String welcome1 (Model model) {
        List<Gym> gyms = this.gymService.findAll();
        model.addAttribute("gyms" , gyms);
        return "gyms.html";
    }

    @GetMapping("/getAllGyms")
    public ResponseEntity<?> getAllGyms () {
        List<Gym> gyms = this.gymService.findAll();
        return new ResponseEntity<>(gyms, HttpStatus.OK);
    }


    @GetMapping("/account/{id}/gyms")
        public String gymPage (Model model){
        List<Gym> gyms = this.gymService.findAll();
        model.addAttribute("gyms" , gyms);
        return "gyms.html";
    }


    @PostMapping("/add-gym")
    public ResponseEntity<?> add(@RequestBody GymDTO gymDTO) {
        Gym gym  = gymService.save(Gym.getGymByDTO(gymDTO));
        if (gym == null)
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<Gym>(HttpStatus.OK);
    }

    @DeleteMapping("/gyms/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        if (gymService.deleteById(id))
            return  new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/gym/{id}")
    public String gym (@PathVariable(name = "id") Long id , Model model) {
        Gym gym  = this.gymService.findOne(id);
        model.addAttribute("gym" , gym);
        return "gym.html";
    }

    @PutMapping("/edit_gym")
    public ResponseEntity<?>edit_gym(@RequestBody Gym gym) {
        try {
            this.gymService.editGym(gym);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
