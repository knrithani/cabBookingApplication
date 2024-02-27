package com.Project.cabbooking.admin;

import com.Project.cabbooking.user.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @PostMapping("user")
    public CustomerAccount registerUser(@RequestBody CustomerAccount account){
        return this.adminService.registerUser(account);

    }
}
