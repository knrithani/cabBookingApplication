package com.project.cabbooking.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Route{

    @Id
    @GeneratedValue
    Integer routeId;
    String startLocation;
    String endLocation;
    Double fare;

    public Route() {
    }

    public Route(String startLocation, String endLocation, Double fare) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.fare = fare;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
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

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
