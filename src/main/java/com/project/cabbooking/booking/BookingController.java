package com.project.cabbooking.booking;

import com.project.cabbooking.driver.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("bookings/{bookingId}")
    public Booking cancelBooking(@PathVariable Integer bookingId) throws BookingExceptions{
        return this.bookingService.cancelBooking(bookingId);
    }

    @GetMapping("bookings/id/{id}")
    public List<Booking> findAllAccountByName(@PathVariable("id") Integer customerId){
        return this.bookingService.findAllBookingsById(customerId);
    }

    //ratings
    @PostMapping("rating/driver/{driverId}")
    public Rating createRating(@RequestBody Rating rating, @PathVariable Integer driverId) throws BookingExceptions{

        return bookingService.createRatingForDriver(driverId, rating);
    }

    @GetMapping("rating/driver/{driverId}/all")
    public List<Rating> getRatingsByDriverId(@PathVariable Integer driverId) throws BookingExceptions{

        return bookingService.getAllRatingsForDriver(driverId);
    }

    @DeleteMapping("rating/driver/{driverId}/rating/{ratingId}")
    public void deleteRating(@PathVariable Integer driverId, @PathVariable Integer ratingId) throws BookingExceptions{

        bookingService.deleteRatingForDriver(driverId, ratingId);

    }
    //payment
    @PostMapping("payment/makePayment")
    public BookingDto makePayment(@RequestBody PaymentDto paymentDto) throws BookingExceptions {
        return bookingService.makePayment(paymentDto);

    }
}
