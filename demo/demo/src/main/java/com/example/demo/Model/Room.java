package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int capacity;

    @Column
    private String mark;

    @ManyToMany(mappedBy = "rooms" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Schedule> trainingSchedule = new HashSet<>();

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Gym gym;

    public Room(Long id, int capacity, String mark, Set<Schedule> trainingSchedule, Gym gym) {
        this.id = id;
        this.capacity = capacity;
        this.mark = mark;
        this.trainingSchedule = trainingSchedule;
        this.gym = gym;
    }

    public Room() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Set<Schedule> getTrainingSchedule() {
        return trainingSchedule;
    }

    public void setTrainingSchedule(Set<Schedule> trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
