package com.project.cabbooking.driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByStartLocationAndEndLocation(String startLocation, String endLocation);
}
