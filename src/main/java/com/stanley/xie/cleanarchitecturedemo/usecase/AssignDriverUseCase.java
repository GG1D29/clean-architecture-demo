package com.stanley.xie.cleanarchitecturedemo.usecase;

import com.stanley.xie.cleanarchitecturedemo.entity.DriverRepository;
import com.stanley.xie.cleanarchitecturedemo.entity.Ride;
import com.stanley.xie.cleanarchitecturedemo.entity.RideRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AssignDriverUseCase {
    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;

    public boolean execute(String rideId, String driverId) {
        Ride ride = rideRepository.findById(rideId);
        if (ride != null && driverRepository.isAvailable(driverId)) {
            ride.assignDriver(driverId);
            rideRepository.update(ride);
            return true;
        }
        return false;
    }
}
