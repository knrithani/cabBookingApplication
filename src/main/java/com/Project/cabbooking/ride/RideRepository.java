package com.Project.cabbooking.ride;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride,Integer> {
    List<Ride> findBDriverIdAndStatus(String DriverId,String status);
}
