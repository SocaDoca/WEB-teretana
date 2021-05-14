package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DoneTraining implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double rating;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Training Training;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    public DoneTraining(Long id, double rating, Training training, User member, User user) {
        this.id = id;
        this.rating = rating;
        this.Training = training;
        this.user = user;
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
        return Training;
    }

    public void setTraining(Training training) {
        this.Training = training;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User trainer) {
        this.member = trainer;
    }
}
