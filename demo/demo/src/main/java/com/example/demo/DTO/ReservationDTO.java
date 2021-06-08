package com.example.demo.DTO;

public class ReservationDTO {

    private Long member_id;

    private Long schedule_id;

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long user_id) {
        this.member_id = member_id;
    }

    public Long getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(Long schedule_id) {
        this.schedule_id = schedule_id;
    }

    public ReservationDTO(Long member_id, Long schedule_id) {
        super();
        this.member_id = member_id;
        this.schedule_id = schedule_id;
    }
    public ReservationDTO() {
    }
}
