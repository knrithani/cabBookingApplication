package com.Project.cabbooking.user;

import com.Project.cabbooking.user.CustomerLoginDto;
import com.Project.cabbooking.user.CustomerAccount;
import com.Project.cabbooking.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("account/login")
    public CustomerAccount userLogin(@RequestBody CustomerLoginDto loginDto){
        return this.customerService.login(loginDto.getCdsId(), loginDto.getPassword());
    }


}
