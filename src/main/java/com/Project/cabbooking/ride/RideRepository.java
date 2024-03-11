package com.Project.cabbooking.ride;

import com.Project.cabbooking.driver.DriverAccount;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RideRepository extends JpaRepository <Ride, Integer>{

}