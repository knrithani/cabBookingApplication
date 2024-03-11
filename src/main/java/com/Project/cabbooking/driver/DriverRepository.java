package com.Project.cabbooking.driver;

import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.user.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverAccount, Integer> {
//    void updateAssignedCab(Integer driverId, Integer cabId);

    DriverAccount getDriverById(Integer driverId);
    Optional<DriverAccount> findByDriverid(String driverId);

}
