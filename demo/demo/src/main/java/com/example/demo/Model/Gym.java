package com.example.demo.Model;

import com.example.demo.DTO.GymDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Gym implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column(nullable=false)
    private String phone_number;

    @Column(unique = true)
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy= "gym",fetch=FetchType.EAGER, orphanRemoval = true)
    private Set<User> trainers=new HashSet<>();

    @OneToMany (mappedBy= "gym",fetch=FetchType.EAGER, orphanRemoval = true,cascade=CascadeType.ALL)
    private Set<Room> rooms=new HashSet<>();

    @OneToMany (mappedBy= "gym",fetch=FetchType.EAGER, orphanRemoval = true,cascade=CascadeType.ALL)
    private Set<Schedule> schedule=new HashSet<>();

    public Gym(Long id, String name, String address, String phoneNum, String email, Set<User> trainer, Set<Room> rooms , Set<Schedule> schedules) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phoneNum;
        this.email = email;
        this.trainers = trainer;
        this.rooms = rooms;
        this.schedule = schedules;

    }

    public Gym() {

    }


    public static Gym getGymByDTO(GymDTO gymDTO) {
        Gym gym = new Gym();
        gym.setAddress(gymDTO.getAddress());
        gym.setEmail(gymDTO.getEmail());
        gym.setName(gymDTO.getName());
        gym.setPhone_number(gymDTO.getPhone_number());
        return gym;
    }

    public Long getId() {
        return id;
    }

    public Set<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Set<Schedule> schedule) {
        this.schedule = schedule;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<User> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<User> trainer) {
        this.trainers = trainer;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }


}
