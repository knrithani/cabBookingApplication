package com.Project.cabbooking.driver;

import com.Project.cabbooking.ride.Ride;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface DriverServices {

    static List<Ride> getCompletedRides(String driverId) {
        return null;
    }

    DriverAccount login(String userEmailId, String userPassword) throws DriverExceptions;

    String applyForLeave(Integer id, LocalDate LeaveDate);
}
