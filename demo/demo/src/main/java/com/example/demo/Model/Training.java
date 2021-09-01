package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column (nullable = false)
    private String type;

    @Column (nullable = false)
    private Long duration;

    @Column
    private double rating;
    @JsonIgnore
    @OneToMany(mappedBy = "training",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DoneTraining> doneTrainings = new HashSet<>();

    @OneToMany(mappedBy = "training", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private  Set<Schedule> schedules = new HashSet<>();

    @Column()
    private Long price;


    public Training(Long id, String name, String description, String type, Long duration, double rating, Long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.rating = rating;
        this.price = price;
    }

    public Training() {

    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
