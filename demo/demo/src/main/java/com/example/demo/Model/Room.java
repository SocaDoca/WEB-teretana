package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long capacity;

    @Column
    private String mark;


    @JsonIgnore
    @ManyToOne(fetch=FetchType.EAGER)
    private Gym gym;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ROOM_SCHEDULE" ,
    joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "schedule_id" , referencedColumnName = "id"))
    private Set<Schedule> schedules = new HashSet<>();


    public Room( Long capacity, String mark, Set<Schedule> schedules, Gym gym) {

        this.capacity = capacity;
        this.mark = mark;
        this.gym = gym;
        this.schedules = schedules;
    }

    public Room() {

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



    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}
