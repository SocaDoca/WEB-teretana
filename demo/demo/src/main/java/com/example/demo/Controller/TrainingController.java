package com.example.demo.Controller;

import com.example.demo.DTO.TrainingsDTO;
import com.example.demo.Model.Training;
import com.example.demo.Service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TrainingController {
    @Autowired
    private TrainingService trainingService;

    @GetMapping("/trainings")
    public String trainings(Model model) {
        TrainingsDTO trainingsDTO=this.trainingService.getData();
        model.addAttribute("trainingsDTO", trainingsDTO);
        return "trainings.html";
    }

    @GetMapping("/training/{id}")
    public String getTraining(@PathVariable(name = "id") Long id, Model model){
        Training training=this.trainingService.findOne(id);
        model.addAttribute("training", training);
        return "training.html";
    }
}
