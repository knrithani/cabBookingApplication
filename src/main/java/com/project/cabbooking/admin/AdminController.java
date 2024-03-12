package com.project.cabbooking.admin;
import com.project.cabbooking.customer.CustomerAccount;
import com.project.cabbooking.driver.CarRepository;
import com.project.cabbooking.driver.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    private DriverRepository driverRepository;
    private CarRepository carRepository;
    @Autowired
    AdminService adminService;

    @PostMapping("user")
    public CustomerAccount registerUser(@RequestBody CustomerAccount account){
        return this.adminService.registerUser(account);

    }
}
