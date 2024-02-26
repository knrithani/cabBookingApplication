package com.Project.cabbooking.adminTest;

import com.Project.cabbooking.admin.AdminService;
import com.Project.cabbooking.booking.Route;
import com.Project.cabbooking.booking.RouteException;
import com.Project.cabbooking.booking.RouteRepository;
import com.Project.cabbooking.car.Car;
import com.Project.cabbooking.driver.DriverAccount;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AdminControllerTest {


    RouteRepository routeRepository;

    AdminService adminService;

@Test
public void testCreatRoute() throws RouteException {
    Route route = new Route("velachery","Gtbc",80.0);
    Route result = adminService.creatRoute(route);
     Route savedRoute = routeRepository.save(route);
    assertEquals(savedRoute, result);
}
//    @Test
//    public void testCreatRoute() throws RouteException {
//        Route route = new Route("pammal","pallavaram",80.0);

//        Route result = adminService.creatRoute(route);
//        assertEquals(route, result);
//    }
    @Test
    public void testDisplayAllCabs() throws RouteException {

        List<Car> carList = Arrays.asList(new Car());
        List<Car> result = adminService.displayAllCabs();

        assertEquals(carList, result);
    }

    @Test
    public void testDisplayAllDrivers() throws RouteException {

        List<DriverAccount> driverList = Arrays.asList(new DriverAccount(1,"person1","person1@gmail.com","passwd",1234567890.0,23422.0));
        List<DriverAccount> result = adminService.displayAllDrivers();

        assertEquals(driverList, result);
    }

}
