package com.example.demo.DTO;

import com.example.demo.Model.Role;

import java.util.Date;

public class TrainerDTO {

    private Long gym_id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String username;
    private String phone_number;
    private String date;
    private Role role;
    private boolean activity;
    public Long getGym_id() {
        return gym_id;
    }
    public void setGym_id(long gym_id) {
        this.gym_id = gym_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public boolean isActivity() {
        return activity;
    }
    public void setActivity(boolean activity) {
        this.activity = activity;
    }
}
