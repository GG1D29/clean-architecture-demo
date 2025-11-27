package com.stanley.xie.cleanarchitecturedemo.entity;

import lombok.Data;

// Core Entity: Ride.java
@Data
public class Ride {
    private String rideId;
    private String passengerId;
    private String driverId;
    private String pickupLocation;
    private String dropoffLocation;
    private RideStatus status;

    public enum RideStatus {
        REQUESTED, ACCEPTED, COMPLETED
    }

    public Ride(String rideId, String passengerId, String pickupLocation, String dropoffLocation) {
        this.rideId = rideId;
        this.passengerId = passengerId;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.status = RideStatus.REQUESTED;
    }

    public void assignDriver(String driverId) {
        this.driverId = driverId;
        this.status = RideStatus.ACCEPTED;
    }

    public void completeRide() {
        this.status = RideStatus.COMPLETED;
    }
}
