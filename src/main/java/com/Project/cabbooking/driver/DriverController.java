package com.Project.cabbooking.driver;

import com.Project.cabbooking.ride.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DriverController {

    @Autowired
    DriverServices driverServices;

    @PostMapping("driver/login")
    public DriverAccount userLogin(@RequestBody Dto driverDto) throws DriverExceptions{
        return this.driverServices.login(driverDto.getEmailId(), driverDto.getPassword());
    }

    @PostMapping("leave/apply")
    public String leaveapply(@RequestBody LeaveDto leaveDto) throws DriverExceptions
    {
        LocalDate leavedate= leaveDto.getLeaveDate();
        Integer  id= leaveDto.getId();
        return this.driverServices.applyForLeave(id, leavedate);

    }

    @GetMapping("rides/completed")
    public List<Ride> getCompletedRides(@PathVariable String DriverId){
        return DriverServices.getCompletedRides(DriverId);
    }



}
