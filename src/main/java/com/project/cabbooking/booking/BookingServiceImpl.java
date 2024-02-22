package com.project.cabbooking.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.cabbooking.driver.Car;
import com.project.cabbooking.driver.CarRepository;
import com.project.cabbooking.customer.CustomerAccount;
import com.project.cabbooking.customer.CustomerRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<Car> listOfCabs(String startLocation, String endLocation) {
        List<Car> carsList = new ArrayList<>();
        carsList = this.carRepository.findAllByStartLocationAndEndLocation(startLocation, endLocation);
        return carsList;
    }

    @Override
    public PaymentDto selectCab(SelectionDto selectionDto) throws BookingExceptions {
        Optional<Car> carOpt = this.carRepository.findById(selectionDto.getCabId());
        if(carOpt.isEmpty()){
            throw new BookingExceptions("Cab does not exist");
        }
        Car car = carOpt.get();
        Double fare = car.getRoute().getFare();
        Integer cabId = car.getId();
        Integer userId = selectionDto.getUserId();
        PaymentDto paymentDto = new PaymentDto(userId, cabId, fare);
        return paymentDto;
    }

    @Override
    public Booking bookCab(BookingDto bookingDto) throws BookingExceptions {

        Optional<Payment> paymentOpt = paymentRepository.findById(bookingDto.getPaymentId());
        if(!bookingDto.getStatus().equals("Success") || paymentOpt.isEmpty()){
            throw new BookingExceptions("Booking unsuccessful due to failed payment");
        }
        Payment payment = paymentOpt.get();
        Optional<Car> carOpt = this.carRepository.findById(bookingDto.getCabId());
        if(carOpt.isEmpty()){
            throw new BookingExceptions("Cab does not exist");
        }
        Car car = carOpt.get();
        Optional<CustomerAccount> userOpt = customerRepository.findById(bookingDto.getCustomerId());
        CustomerAccount user = userOpt.get();
        if(car.getAvailableSeats() == 0){
            throw new BookingExceptions("Cab full!");
        }
        car.setAvailableSeats(car.getAvailableSeats()-1);
        Booking booking = new Booking();

        String startLocation = car.getRoute().getStartLocation();
        String endLocation = car.getRoute().getEndLocation();
        LocalDate bookingDate = bookingDto.getDate();
        LocalTime bookingTime = LocalTime.now();
        String status = "Success";
        Double fare = bookingDto.getAmount();

        booking.setStartLocation(startLocation);
        booking.setEndLocation(endLocation);
        booking.setBookingDate(bookingDate);
        booking.setBookingTime(bookingTime);
        booking.setStatus(status);
        booking.setFare(fare);
        booking.setCar(car);
        booking.setPayment(payment);

        user.getBookings().add(booking);

        this.bookingRepository.save(booking);
        this.carRepository.save(car);
        this.customerRepository.save(user);

        return booking;

    }
}
