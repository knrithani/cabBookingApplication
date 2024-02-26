package com.Project.cabbooking.admin;

import com.Project.cabbooking.booking.Route;
import com.Project.cabbooking.booking.RouteException;
import com.Project.cabbooking.car.Car;
import com.Project.cabbooking.car.CarRepository;
import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.driver.DriverRepository;
import com.Project.cabbooking.user.CustomerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    @GetMapping("Cabs")
    public List<Car> displayAllCabs() throws RouteException {
        return this.adminService.displayAllCabs();
    }

    @GetMapping("Drivers")
        public List<DriverAccount> displayAllDrivers() throws RouteException {
            return this.adminService.displayAllDrivers();
        }


    @DeleteMapping("location/{locationId}")
    public void deleteLocation(@PathVariable Integer locationId) throws RouteException {
         this.adminService.deleteRoute(locationId);
    }
    @PostMapping("locations")
    public Route createRoute(Route route) throws RouteException {
        return this.adminService.creatRoute(route);
        }

    @GetMapping("location")
    public List<Route> displayAllLocations() throws RouteException {
        return this.adminService.displayAllLocations();
    }

    @PutMapping("updatefare/{locationId}/{fare}")
    public Optional<Route> updateFare(@PathVariable Integer locationId, @PathVariable Double fare) throws RouteException {
        return this.adminService.updateFare(locationId,fare);
    }

    @GetMapping("getfare/{locationId}")
    public Double getFare(@PathVariable Integer locationId) throws RouteException {
        return this.adminService.getFare(locationId);
    }

    @PostMapping("assigningCabToDriver/{cabId}/{driverId}")
    public Map<Integer,Integer> assigningCabToDriver(@PathVariable Integer cabId,@PathVariable Integer driverId){
        return this.adminService.assignCabToDriver(cabId,driverId);
    }

    public AdminController(CarRepository carRepository, DriverRepository driverRepository) {
        this.carRepository = carRepository;
        this.driverRepository = driverRepository;
    }

//    @PostMapping("/assignCabToDriver")
//    public String assignCabToDriver(@RequestParam Integer driverId, @RequestParam Integer cabId) {
//        Car car = carRepository.getCarById(cabId);
//        if (car == null) {
//            return "Cab not found";
//        }
//
//        DriverAccount driver = driverRepository.getDriverById(driverId);
//        if (driver == null) {
//            return "Driver not found";
//        }
//
//        // Update the driver's assigned cab
//        driverRepository.updateAssignedCab(driverId, cabId);
//
//        return "Assigned cab " + cabId + " to driver " + driverId;
//    }
}

//    @PutMapping("updatingcabdriver/{cabid}/{driverid}")
//    public Map<Integer>
//    @GetMapping("driverCabData")
//    public List<Map<Integer,Integer> >getAllCabDriverData(){
//        return this.adminService.getAllCabDriverData();
//    }


