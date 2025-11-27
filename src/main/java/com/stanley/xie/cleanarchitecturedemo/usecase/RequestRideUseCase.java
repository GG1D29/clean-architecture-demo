package com.stanley.xie.cleanarchitecturedemo.usecase;

import com.stanley.xie.cleanarchitecturedemo.entity.Ride;
import com.stanley.xie.cleanarchitecturedemo.entity.RideRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class RequestRideUseCase {
    private final RideRepository rideRepository;

    public String execute(String passengerId, String pickup, String dropoff) {
        String rideId = UUID.randomUUID().toString();
        Ride ride = new Ride(rideId, passengerId, pickup, dropoff);
        rideRepository.save(ride);

        return rideId;
    }
}
