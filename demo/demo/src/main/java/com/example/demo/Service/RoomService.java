package com.example.demo.Service;

import com.example.demo.Model.Gym;
import com.example.demo.Model.Room;
import com.example.demo.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GymService gymService;

    public Room findOne(Long id){
        Room room=this.roomRepository.findById(id).get();
        return room;
    }
    public List<Room> findAll(){
        List<Room> rooms=this.roomRepository.findAll();
        return rooms;
    }
    public Room save(Room room) {
        return this.roomRepository.save(room);
    }
    public void editRoom(Room room) {
        this.roomRepository.updateRoom(room.getId(),room.getCapacity(),room.getMark());
    }
    public boolean deleteById(Long cinema_id,Long room_id) {
        try {
            Gym gym=this.gymService.findOne(cinema_id);
            Room room=this.roomRepository.findById(room_id).get();
            gym.getRooms().remove(room);
            room.getSchedules().clear();
            this.roomRepository.deleteById(room_id);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}
