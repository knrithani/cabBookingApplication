package com.Project.cabbooking.driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DriverRepository extends JpaRepository<DriverAccount, Integer> {


    Optional<DriverAccount> findByEmailId(String emailID);


}
