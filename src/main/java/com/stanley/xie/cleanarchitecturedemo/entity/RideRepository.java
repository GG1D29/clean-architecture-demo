package com.stanley.xie.cleanarchitecturedemo.entity;

public interface RideRepository {
    void save(Ride ride);

    Ride findById(String rideId);

    void update(Ride ride);
}
