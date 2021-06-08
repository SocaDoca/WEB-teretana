package com.example.demo.DTO;

import java.util.Date;

public class ScheduleDTO {


    private Date day;

    private String time;

    private Long price;

    private Long training_id;

    private Long room_id;

    private Long gym_id;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Long training_id) {
        this.training_id = training_id;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getGym_id() {
        return gym_id;
    }

    public void setGym_id(Long gym_id) {
        this.gym_id = gym_id;
    }

    public ScheduleDTO() {}
}

