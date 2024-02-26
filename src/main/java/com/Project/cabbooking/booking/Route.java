package com.Project.cabbooking.booking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Route{

@Id
@GeneratedValue
Integer locationId;
    String startlocation;

    String endLocation;
    Double fare;


    public Route() {
    }

    public Route(String startlocation, String endLocation, Double fare) {
        this.startlocation = startlocation;
        this.endLocation = endLocation;
        this.fare = fare;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getStartlocation() {
        return startlocation;
    }

    public void setStartlocation(String startlocation) {
        this.startlocation = startlocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
