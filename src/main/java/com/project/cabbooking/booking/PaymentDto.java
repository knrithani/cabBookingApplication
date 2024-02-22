package com.project.cabbooking.booking;

public class PaymentDto {
    private Integer userId;
    private Integer cabId;
    private Double fare;

    public PaymentDto() {
    }

    public PaymentDto(Integer userId, Integer cabId, Double fare) {
        this.userId = userId;
        this.cabId = cabId;
        this.fare = fare;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
