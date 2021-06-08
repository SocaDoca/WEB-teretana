package com.example.demo.DTO;

public class RoomDTO {
    private Long gym_id;
    private Long capacity;
    private String mark;
    public Long getGym_id() {
        return gym_id;
    }
    public void setGym_id(Long gym_id) {
        this.gym_id = gym_id;
    }
    public Long getCapacity() {
        return capacity;
    }
    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public RoomDTO() {

    }
}
