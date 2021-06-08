package com.example.demo.DTO;

public class RatingDTO {
    private Long training_id;

    private Long done_training_id;

    private Long rating;

    public Long getTraining_id() {
        return training_id;
    }

    public void setTraining_id(Long training_id) {
        this.training_id = training_id;
    }

    public Long getDone_training_id() {
        return done_training_id;
    }

    public void setDone_training_id(Long done_training_id) {
        this.done_training_id = done_training_id;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public RatingDTO(Long movie_id, Long done_training_id, Long rating) {
        super();
        this.training_id = movie_id;
        this.done_training_id = done_training_id;
        this.rating = rating;
    }

    public RatingDTO() {

    }
}
