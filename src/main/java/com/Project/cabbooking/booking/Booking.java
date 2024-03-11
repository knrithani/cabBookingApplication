package com.Project.cabbooking.booking;

import com.Project.cabbooking.car.CarAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer id;
    private String startLocation;
    private String endLocation;
    private LocalDate bookingDate;
    private LocalTime bookingTime;
    private LocalDate rideDate;
    private String status;
    private Double fare;

    @OneToOne
    private Payment payment;

    @OneToOne
    private Rating rating;

    @OneToOne
    private CarAccount car;

    public Booking() {
    }

    public Booking(Integer id, String startLocation, String endLocation, LocalDate bookingDate, LocalTime bookingTime, LocalDate rideDate, String status, Double fare, Payment payment, Rating rating, CarAccount car) {
        this.id = id;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.rideDate = rideDate;
        this.status = status;
        this.fare = fare;
        this.payment = payment;
        this.rating = rating;
        this.car = car;
    }

    public Booking(String startLocation, String endLocation, LocalDate bookingDate, LocalTime bookingTime, LocalDate rideDate, String status, Double fare, Payment payment, Rating rating) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.rideDate = rideDate;
        this.status = status;
        this.fare = fare;
        this.payment = payment;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public CarAccount getCar() {
        return car;
    }

    public void setCar(CarAccount car) {
        this.car = car;
    }

    public LocalDate getRideDate() {
        return rideDate;
    }

    public void setRideDate(LocalDate rideDate) {
        this.rideDate = rideDate;
    }
}
