package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ReservedTraining implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Schedule trainingSchedule;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Training Training;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User member;

    public ReservedTraining(Long id, Schedule trainingSchedule, User user, Training training, User member) {
        this.id = id;
        this.trainingSchedule = trainingSchedule;
        this.user = user;
        this.Training = training;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Schedule getTrainingSchedule() {
        return trainingSchedule;
    }

    public void setTrainingSchedule(Schedule trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Training getTraining() {
        return Training;
    }

    public void setTraining(Training training) {
        this.Training = training;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }
}
