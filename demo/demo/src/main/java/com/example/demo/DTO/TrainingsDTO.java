package com.example.demo.DTO;

import com.example.demo.Model.Training;

import java.util.List;

public class TrainingsDTO {

    private List<Training> trainings;

    private List<String> types;

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
    public TrainingsDTO(){}

    public TrainingsDTO(List<Training> movies, List<String> types) {
        super();
        this.trainings = movies;
        this.types = types;
    }
}
