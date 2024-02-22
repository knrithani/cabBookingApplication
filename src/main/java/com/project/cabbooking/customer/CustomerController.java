package com.project.cabbooking.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountException;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("account/login")
    public CustomerAccount userLogin(@RequestBody CustomerLoginDto loginDto) throws CustomerExceptions{
        return this.customerService.login(loginDto.getCdsId(), loginDto.getPassword());
    }

}
