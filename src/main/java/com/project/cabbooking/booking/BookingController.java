package com.project.cabbooking.booking;

import com.project.cabbooking.driver.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("cabs")
    public List<Car> listOfCabs(@RequestBody LocationDto locationDto){
        return this.bookingService.listOfCabs(locationDto.getStartLocation(), locationDto.getEndLocation());
    }

    @PostMapping("selectCab")
    public PaymentDto selectCab(@RequestBody SelectionDto selectionDto)throws BookingExceptions{
        return this.bookingService.selectCab(selectionDto);
    }

    @PostMapping("bookCab")
    public Booking bookCab(@RequestBody BookingDto bookingDto) throws BookingExceptions{
        return this.bookingService.bookCab(bookingDto);
    }
}
