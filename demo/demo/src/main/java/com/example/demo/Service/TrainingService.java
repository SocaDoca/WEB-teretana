package com.example.demo.Service;

import com.example.demo.DTO.TrainerDTO;
import com.example.demo.DTO.TrainingsDTO;
import com.example.demo.Model.Training;
import com.example.demo.Repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public Training findOne(Long id) {
        Training training=this.trainingRepository.findById(id).get();
        return training;
    }

    public List<Training> findAll(){
        List<Training> training=this.trainingRepository.findAll();
        return training;
    }

    public Training save(Training training) {
        return this.trainingRepository.save(training);
    }

    public TrainingsDTO getData(){
        List<Training> trainings=findAll();
        List<String> types=new ArrayList<String>();
        for(int i=0;i<trainings.size();i++)
        {
            if(!types.contains(trainings.get(i).getType())) {
                types.add(trainings.get(i).getType());
            }
        }
        return new TrainingsDTO(trainings,types);
    }
    public void setRating(Long id,Long rating) {
        this.trainingRepository.setRating(id, rating);
    }
}
