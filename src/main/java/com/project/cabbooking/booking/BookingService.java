package com.project.cabbooking.booking;

import com.project.cabbooking.driver.Car;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    List<Car> listOfCabs(String startLocation, String endLocation);

    PaymentDto selectCab(SelectionDto selectionDto) throws BookingExceptions;

    Booking bookCab(BookingDto bookingDto) throws BookingExceptions;

    Rating createRatingForDriver(Integer driverId, Rating rating) throws BookingExceptions;

    List<Rating> getAllRatingsForDriver(Integer driverId)  throws BookingExceptions;

    Rating deleteRatingForDriver(Integer driverId, Integer ratingId) throws BookingExceptions;

    BookingDto makePayment(PaymentDto paymentDto) throws BookingExceptions;

    List<Booking> findAllBookingsById(Integer customerId);

    Booking cancelBooking(Integer bookingId);
}
