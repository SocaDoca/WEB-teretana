package com.example.demo.Service;

import com.example.demo.Model.Gym;
import com.example.demo.Model.Room;
import com.example.demo.Model.Schedule;
import com.example.demo.Model.User;
import com.example.demo.Repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;

    @Autowired
    private UserService userService;


    public Gym findOne(Long id) {
        try {
            Gym gym = this.gymRepository.findById(id).get();
            return gym;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Gym> findAll() {
        List<Gym> gyms = this.gymRepository.findAll();
        return gyms;
    }

    public Gym save(Gym gym) {
        if (gym.getName().trim().length() <= 3 || gym.getAddress().trim().length() <= 3
                || gym.getEmail().trim().length() <= 3 || gym.getPhone_number().trim().length() <= 3) {
            return null;
        }
        return this.gymRepository.save(gym);
    }

    public boolean deleteById(Long id) {
        try {
            Gym gym=gymRepository.findById(id).get();
            List<User> users=this.userService.findAll();
            for(int i=0;i<users.size();i++) {
                for(Schedule sched: users.get(i).getReserved_training()) {
                    if(sched.getGym().getId()==gym.getId()) {
                        users.get(i).getReserved_training().remove(sched);
                    }
                }
            }
            for(Room room : gym.getRooms()){
                room.getSchedules().clear();
            }
            gym.getSchedule().clear();
            gym.getRooms().clear();
            gymRepository.delete(gym);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void editGym(Gym gym) {
        this.gymRepository.updateGym(gym.getId(),gym.getName(),gym.getAddress(),gym.getPhone_number(),gym.getEmail());
    }

}
