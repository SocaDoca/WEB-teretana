package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class DoneTraining implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double rating;

    @ManyToOne
    private Training training;

    @JsonIgnore
    @ManyToOne
    private User member;


    public DoneTraining(Long id, double rating, Training training, User member) {
        this.id = id;
        this.rating = rating;
        this.training = training;
        this.member = member;
    }

    public DoneTraining() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User trainer) {
        this.member = trainer;
    }
}
