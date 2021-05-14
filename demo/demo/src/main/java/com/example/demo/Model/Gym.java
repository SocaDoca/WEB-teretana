package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Gym implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phoneNum;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy= "gym",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<User> trainer=new HashSet<>();

    @OneToMany (mappedBy= "gym",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Room> rooms=new HashSet<>();

    public Gym(Long id, String name, String address, String phoneNum, String email, Set<User> trainer, Set<Room> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.email = email;
        this.trainer = trainer;
        this.rooms = rooms;

    }

    public Gym() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<User> getTrainer() {
        return trainer;
    }

    public void setTrainer(Set<User> trainer) {
        this.trainer = trainer;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
