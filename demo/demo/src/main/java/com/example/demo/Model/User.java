package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phone;

    @Column (unique = true)
    private String email;

    @Column
    private String date_of_birth;

    @Column
    private Role role;

    @Column
    private Boolean active;

    @OneToMany( mappedBy = "member", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<DoneTraining> doneTrainings=new HashSet<>();

    @OneToMany( mappedBy = "member", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <ReservedTraining> reservedTraining=new HashSet<>();

    @OneToMany( mappedBy = "trainer", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Training> training=new HashSet<>();

    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Gym gym;

    public User(Long id, String username, String password, String name, String surname, String phone, String email, String date_of_birth, Role role, Boolean active, Set<DoneTraining> doneTrainings, Set<ReservedTraining> reservedTraining, Set<Training> training, Gym gym) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.role = role;
        this.active = active;
        this.doneTrainings = doneTrainings;
        this.reservedTraining = reservedTraining;
        this.training = training;
        this.gym = gym;
    }

    public User() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public Set<Training> getTraining() {
        return training;
    }

    public void setTraining(Set<Training> training) {
        this.training = training;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
