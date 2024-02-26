package com.Project.cabbooking.admin;

import com.Project.cabbooking.booking.BookingRepository;
import com.Project.cabbooking.booking.Route;
import com.Project.cabbooking.booking.RouteException;
import com.Project.cabbooking.booking.RouteRepository;
import com.Project.cabbooking.car.Car;
import com.Project.cabbooking.car.CarRepository;
import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.driver.DriverRepository;
import com.Project.cabbooking.user.CustomerAccount;
import com.Project.cabbooking.user.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public CustomerAccount registerUser(CustomerAccount account) {
        return this.customerRepository.save(account);
    }

    @Override
    public List<Car> displayAllCabs() throws RouteException {
        if(carRepository.findAll().isEmpty()){
            throw new RouteException("There is no cab added");
        }

        return this.carRepository.findAll();
    }

    @Override
    public List<DriverAccount> displayAllDrivers() throws RouteException {
        if(driverRepository.findAll().isEmpty()){
            throw new RouteException("There is no driver added");
        }
        return this.driverRepository.findAll();
    }

    @Override
    public Route creatRoute(Route route) throws RouteException {
        Optional<Route> isRoutePresent=this.routeRepository.findById(route.getLocationId());
        if(isRoutePresent.isPresent()){
            throw new RouteException("Route is already present");
        }
        return this.routeRepository.save(route);
    }

    @Override
    public void deleteRoute(Integer routeId) throws RouteException {
        if(routeRepository.findById(routeId).isEmpty()){
            throw  new RouteException("The location does not exist");
        }
        this.routeRepository.delete(routeRepository.findById(routeId).get());

//        return Optional.empty();
    }

    @Override
    public List<Route> displayAllLocations() throws RouteException {
        if(routeRepository.findAll().isEmpty()){
            throw new RouteException(("There is no route added to view"));
        }
        return this.routeRepository.findAll();
    }


    @Override
    public Optional<Route> updateFare(Integer routeId, Double fare) throws RouteException {
        Optional<Route> route=this.routeRepository.findById(routeId);
        if(routeRepository.findById(routeId).isEmpty()){
            throw new RouteException("Route is not present to update the fare");
        }
        route.get().setFare(fare);
        return route;
    }

    @Override
    public Double getFare(Integer routeId) throws RouteException {
        if(routeRepository.findById(routeId).isEmpty()){
            throw new RouteException("The Location does not exist ");
        }
        return this.routeRepository.findById(routeId).get().getFare();
    }

    @Override
    public Map<Integer, Integer> assignCabToDriver(Integer cabId, Integer driverId) {
        Map<Integer,Integer> cabDriverMatch=new HashMap<>();
        cabDriverMatch.put(cabId,driverId);
        return cabDriverMatch;
    }


//    @Override
//    public List<Map<Integer, Integer>> getAllCabDriverData(){
//        return routeRepository.findAll();
//    }

//    @Override
//    public Double getFareByLocationName(String routeName){
//        return this.routeRepository.findByLocationName(routeName).get().getFare();
//    }

//    @Override
//    public Optional<Route> findByLocationName(String routeName){
//        return this.routeRepository.findById(routeName).get().getLocationId();
//    }

}
