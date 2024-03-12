package com.Project.cabbooking.driver;

import com.Project.cabbooking.booking.Rating;
import com.Project.cabbooking.car.CarAccount;
import com.Project.cabbooking.ride.Ride;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DriverAccount {

    @Id
    @GeneratedValue
    private Integer id;

    private String driverid;
    private String name;
    private String emailId;
    private String password;
    private Long phoneNumber;
    private String licenseNumber;

    @OneToMany
    private List<Rating> ratings = new ArrayList<>();

    @OneToOne
    @JsonIgnore
    private CarAccount car;

    @OneToMany
    private List<Ride> rides = new ArrayList<>();

    public DriverAccount() {
    }

    public DriverAccount(String name, String emailId, String password, Long phoneNumber, String licenseNumber) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
    }
    public DriverAccount(Integer id, String driverid, String name, String emailId, String password, Long phoneNumber, String licenseNumber, List<Rating> ratings, CarAccount car, List<Ride> rides) {
        this.id = id;
        this.driverid = driverid;
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.ratings = ratings;
        this.car = car;
        this.rides = rides;

    }

    public DriverAccount(int i, String person1, String mail, String passwd, double v, double v1) {
    }


    public Integer getId() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }
    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public CarAccount getCar() {
        return car;
    }

    public void setCar(CarAccount car) {
        this.car = car;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
//    public List<Rating> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(List<Rating> ratings) {
//        this.ratings = ratings;
//    }
//
//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    public List<Ride> getRides() {
//        return rides;
//    }
//
//    public void setRides(List<Ride> rides) {
//        this.rides = rides;
//    }
}
