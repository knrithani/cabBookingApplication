package com.project.cabbooking.booking;

import com.project.cabbooking.driver.Car;

import java.util.List;

public interface BookingService {
    List<Car> listOfCabs(String startLocation, String endLocation);

    PaymentDto selectCab(SelectionDto selectionDto) throws BookingExceptions;

    Booking bookCab(BookingDto bookingDto) throws BookingExceptions;
}
