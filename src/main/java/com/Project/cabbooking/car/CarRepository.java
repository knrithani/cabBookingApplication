package com.Project.cabbooking.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<CarAccount, Integer> {
    Optional<CarAccount> findByCarNumber(String carNumber);

    Car getCarById(Integer id);
}