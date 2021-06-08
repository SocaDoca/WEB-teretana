package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private String username;

    @Column (nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column
    private String phone_number;

    @Column (unique = true , nullable = false)
    private String email;

    @Column
    private String date_of_birth;

    @Column (nullable = false)
    private Role role;

    @Column
    private Boolean active;

    @OneToMany( mappedBy = "member", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Set<DoneTraining> doneTrainings=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RESERVATIONS",
    joinColumns = @JoinColumn(name = "member_id" , referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name ="schedule_id" , referencedColumnName = "id"))
    Set<Schedule> reserved_training = new HashSet<>();

    public Set<Schedule> getReserved_training() {
        return reserved_training;
    }

    public void setReserved_training(Set<Schedule> reserved_training) {
        this.reserved_training = reserved_training;
    }

    @ManyToOne( fetch = FetchType.EAGER )
    private Gym gym;

    public User( String username, String password, String name, String surname, String phone, String email, String date_of_birth, Role role, Boolean active,Gym gym ,Set<DoneTraining> doneTrainings,Set<Schedule> reserved_trainings)   {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.role = role;
        this.active = active;
        this.doneTrainings = doneTrainings;
        this.gym = gym;
        this.reserved_training = reserved_trainings;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone) {
        this.phone_number = phone;
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
    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
