package com.Project.cabbooking.driver;

public class RideDto {
    private Integer id;
    private String driverId;

    private String customerId;

    private String status;

    public RideDto(Integer id, String driverId, String customerId, String status) {
        this.id = id;
        this.driverId = driverId;
        this.customerId = customerId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
