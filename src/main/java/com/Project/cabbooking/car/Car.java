package com.Project.cabbooking.car;


import com.Project.cabbooking.booking.Booking;
import com.Project.cabbooking.driver.DriverAccount;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Integer id;
    private String type;
    private String carNumber;
    private Integer capacity;
    private Integer availableSeats;
    private String location;
    private String tripType;
    @OneToOne
    private DriverAccount driver;

    @OneToMany
    private List<Booking> bookings = new ArrayList<>();

    public Car() {
    }

    public Car(String type, String carNumber, Integer capacity, Integer availableSeats, String location, String tripType, DriverAccount driver, List<Booking> bookings) {
        this.type = type;
        this.carNumber = carNumber;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.location = location;
        this.tripType = tripType;
        this.driver = driver;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DriverAccount getDriver() {
        return driver;
    }

    public void setDriver(DriverAccount driver) {
        this.driver = driver;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
