package com.example.demo.Controller;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainerController {

    @Autowired
    private UserService userService;

    @GetMapping("/account/{id}/verifyTrainer")
    public String verifyTrainer(@PathVariable(name = "id") Long id, Model model) {
        User user=this.userService.findOne(id);
        model.addAttribute("user", user);
        if(user.getRole() == Role.ADMIN) {
            List<User> members=this.userService.getTrainers();
            List<User> result = new ArrayList<User>();
            for (User var : members) {
                if (var.getActive() == false) {
                    result.add(var);
                }
            }
            model.addAttribute("trainers", result);
            return "verifyTrainer.html";
        } else {
            return "index.html";
        }
    }
}
