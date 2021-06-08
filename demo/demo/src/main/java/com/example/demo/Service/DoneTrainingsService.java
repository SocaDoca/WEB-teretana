package com.example.demo.Service;

import com.example.demo.Model.DoneTraining;
import com.example.demo.Repository.DoneTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoneTrainingsService {
    @Autowired
    private DoneTrainingRepository doneTrainingRepository;

    public DoneTraining findOne(Long id) {
        DoneTraining doneTraining=this.doneTrainingRepository.findById(id).get();
        return doneTraining;
    }

    public List<DoneTraining> findAll(){
        List<DoneTraining> doneTraining=this.doneTrainingRepository.findAll();
        return doneTraining;
    }

    public DoneTraining save(DoneTraining doneTraining) {
        return this.doneTrainingRepository.save(doneTraining);
    }

    public List<DoneTraining> getRatedMovies(Long id){
        return this.doneTrainingRepository.findByTrainingId(id);
    }
    public void setRating(Long id,long rating) {
        this.doneTrainingRepository.setRating(id, rating);
    }

    public double calculateRating(Long id) {
        List<DoneTraining> rated=this.doneTrainingRepository.findByTrainingId(id);
        double avg=0;
        int counter=0;
        for(int i=0;i<rated.size();i++) {
            if(rated.get(i).getRating()==0) {
                continue;
            }
            else {
                avg+=rated.get(i).getRating();
                counter++;
            }
        }
        avg/=counter;
        return avg;
    }
}
