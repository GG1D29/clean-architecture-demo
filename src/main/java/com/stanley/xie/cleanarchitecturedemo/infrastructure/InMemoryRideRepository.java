package com.stanley.xie.cleanarchitecturedemo.infrastructure;

import com.stanley.xie.cleanarchitecturedemo.entity.Ride;
import com.stanley.xie.cleanarchitecturedemo.entity.RideRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRideRepository implements RideRepository {
    private Map<String, Ride> rides = new HashMap<>();

    @Override
    public void save(Ride ride) {
        rides.put(ride.getRideId(), ride);
    }

    @Override
    public Ride findById(String rideId) {
        return rides.get(rideId);
    }

    @Override
    public void update(Ride ride) {
        rides.put(ride.getRideId(), ride);
    }
}
