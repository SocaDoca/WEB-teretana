package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private String duration;

    @Column
    private double rating;

    @OneToMany(mappedBy = "Training",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DoneTraining> doneTrainings = new HashSet<>();

    @OneToMany(mappedBy = "Training", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Set<ReservedTraining> reservedTraining = new HashSet<>();

    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private User trainer;

    public Training(Long id, String name, String description, String type, String duration, double rating, Set<DoneTraining> doneTrainings, Set<ReservedTraining> reservedTraining, User trainer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.rating = rating;
        this.doneTrainings = doneTrainings;
        this.reservedTraining = reservedTraining;
        this.trainer = trainer;
    }

    public Training() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Set<DoneTraining> getDoneTrainings() {
        return doneTrainings;
    }

    public void setDoneTrainings(Set<DoneTraining> doneTrainings) {
        this.doneTrainings = doneTrainings;
    }

    public Set<ReservedTraining> getReservedTraining() {
        return reservedTraining;
    }

    public void setReservedTraining(Set<ReservedTraining> reservedTraining) {
        this.reservedTraining = reservedTraining;
    }

    public User getTrainer() {
        return trainer;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }
}
