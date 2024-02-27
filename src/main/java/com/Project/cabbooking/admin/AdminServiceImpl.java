package com.Project.cabbooking.admin;

import com.Project.cabbooking.admin.AdminService;
import com.Project.cabbooking.user.CustomerRepository;
import com.Project.cabbooking.user.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerAccount registerUser(CustomerAccount account) {
        return this.customerRepository.save(account);
    }
}
