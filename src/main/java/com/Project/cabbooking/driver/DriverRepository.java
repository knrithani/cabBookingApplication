package com.Project.cabbooking.driver;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverAccount, Integer> {
//    void updateAssignedCab(Integer driverId, Integer cabId);

    DriverAccount getDriverById(Integer driverId);
}
