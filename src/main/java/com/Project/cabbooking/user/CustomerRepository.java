package com.Project.cabbooking.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository <CustomerAccount, Integer>{
    Optional<CustomerAccount> findByCdsId(String cdsId);
}
