package com.Project.cabbooking.admin;

import com.Project.cabbooking.booking.Route;
import com.Project.cabbooking.booking.RouteException;
import com.Project.cabbooking.car.Car;
import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.user.CustomerAccount;
import com.Project.cabbooking.booking.Booking;
import com.Project.cabbooking.car.CarAccount;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AdminService {

    CustomerAccount registerUser(CustomerAccount account);

    List<Car> displayAllCabs() throws RouteException;

    List<DriverAccount> displayAllDrivers()throws RouteException;

    Route creatRoute(Route route) throws RouteException;


    void deleteRoute(Integer routeId) throws RouteException;

    List<Route> displayAllLocations() throws RouteException;

    Optional<Route> updateFare(Integer locationId, Double fare) throws RouteException;

    Double getFare(Integer locationId) throws RouteException;

    Map<Integer,Integer> assignCabToDriver(Integer cabId, Integer driverId);

    DriverAccount registerDriver(DriverAccount account)throws AdminExceptions;

    CarAccount registerCar(CarAccount account) throws AdminExceptions;

    public List<Booking> getAllTrips(String cdsId) throws AdminExceptions;

    List<Booking> getAllBookings() throws AdminExceptions;

    List<Ride> getAllTrips() throws AdminExceptions;

    List<List<Booking>> getAllCustomerBookings();

    List<List<Ride>> getAllDriverTrips();

//    List<Map<Integer, Integer>> getAllCabDriverData();

//    Map<Integer, Integer> getAllCabDriverData(Integer cabId);


}
