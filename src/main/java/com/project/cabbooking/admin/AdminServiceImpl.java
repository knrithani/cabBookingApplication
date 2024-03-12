package com.project.cabbooking.admin;
import com.project.cabbooking.customer.CustomerAccount;
import com.project.cabbooking.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerAccount registerUser(CustomerAccount account) {
        return this.customerRepository.save(account);
    }
}
