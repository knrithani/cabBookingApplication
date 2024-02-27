package com.Project.cabbooking.car;

import com.Project.cabbooking.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
