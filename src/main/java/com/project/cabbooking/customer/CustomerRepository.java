package com.project.cabbooking.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerAccount, Integer> {
}
