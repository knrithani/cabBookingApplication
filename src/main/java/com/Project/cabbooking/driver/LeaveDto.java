package com.Project.cabbooking.driver;

import java.time.LocalDate;

public class LeaveDto {

    private static Integer id;


    private LocalDate LeaveDate;

    public LeaveDto(LocalDate leaveDate) {
        LeaveDate = leaveDate;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        LeaveDto.id = id;
    }

    public LocalDate getLeaveDate() {
        return LeaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        LeaveDate = leaveDate;
    }
}

