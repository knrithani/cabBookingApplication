package com.Project.cabbooking.admin;
import com.Project.cabbooking.booking.Booking;
import com.Project.cabbooking.booking.BookingRepository;
import com.Project.cabbooking.car.CarAccount;
import com.Project.cabbooking.car.CarRepository;
import com.Project.cabbooking.driver.DriverAccount;
import com.Project.cabbooking.driver.DriverRepository;
import com.Project.cabbooking.ride.Ride;
import com.Project.cabbooking.ride.RideRepository;
import com.Project.cabbooking.user.CustomerAccount;
import com.Project.cabbooking.user.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements com.Project.cabbooking.admin.AdminService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RideRepository rideRepository;

    @Override
    public CustomerAccount registerUser(CustomerAccount account) throws AdminExceptions {
        Optional<CustomerAccount> customerOpt = customerRepository.findByCdsId(account.getCdsId());
        if (customerOpt.isPresent()) {
            throw new AdminExceptions("User Email already exists");
        }
        return this.customerRepository.save(account);
    }

    @Override
    public DriverAccount registerDriver(DriverAccount account) throws AdminExceptions {
        Optional<DriverAccount> driverOpt = driverRepository.findByDriverid(account.getDriverid());
        if (driverOpt.isPresent()) {
            throw new AdminExceptions("Driver ID already exists");
        }
        return this.driverRepository.save(account);

    }

    @Override
    public CarAccount registerCar(CarAccount account) throws AdminExceptions {
        Optional<CarAccount> carOpt = carRepository.findByCarNumber(account.getCarNumber());
        if (carOpt.isPresent()) {
            throw new AdminExceptions("Car is already Registered");
        }
        return this.carRepository.save(account);
    }

    @Override
    public List<Booking> getAllTrips(String cdsId) throws AdminExceptions {
        //customer exception
        Optional<CustomerAccount> opt = customerRepository.findByCdsId(cdsId);
        if(opt.isPresent()) {
            List<Booking> trips = bookingRepository.findAll();
            return trips;

        }
        throw new AdminExceptions("Invalid Id");
    }

    @Override
    public List<Booking> getAllBookings() throws AdminExceptions {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    @Override
    public List <Ride> getAllTrips() throws AdminExceptions {
        List<Ride> rides = rideRepository.findAll();
        return rides;
    }

    @Override
    public List<List<Booking>> getAllCustomerBookings() {
        List<CustomerAccount> sortedList = customerRepository.findAll().stream().sorted(Comparator.comparing(CustomerAccount::getName)).collect(Collectors.toList());
        List<List<Booking>> bookingList = new ArrayList<>();
        for(CustomerAccount customerAccount: sortedList){
            bookingList.add(customerAccount.getBookings());
        }
        return bookingList;
    }

    @Override
    public List<List<Ride>> getAllDriverTrips() {
        List<DriverAccount> sortedList = driverRepository.findAll().stream().sorted(Comparator.comparing(DriverAccount::getName)).collect(Collectors.toList());
        List<List<Ride>> rideList = new ArrayList<>();
        for(DriverAccount driverAccount : sortedList){
            rideList.add(driverAccount.getRides());
        }
        return rideList;
    }
    }

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
