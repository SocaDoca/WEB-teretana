package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date day;

    @Column
    private String time;


    @Column
    private Long price;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Gym gym;

    @ManyToMany(mappedBy ="schedules" ,cascade = CascadeType.ALL)
    private Set<Room> rooms = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "reserved_training")
    private Set<User> members = new HashSet<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Training training;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Schedule(Long id, Date day,String time, Long price, Gym gym, Set<Room> rooms, Set<User> members, Training training) {
        this.id = id;
        this.day = day;
        this.price = price;
        this.time = time;
        this.gym = gym;
        this.rooms = rooms;
        this.members = members;
        this.training = training;
    }

    public Schedule() {}
}