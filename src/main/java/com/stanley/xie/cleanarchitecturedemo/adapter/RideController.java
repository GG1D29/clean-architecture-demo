package com.stanley.xie.cleanarchitecturedemo.adapter;

import com.stanley.xie.cleanarchitecturedemo.usecase.AssignDriverUseCase;
import com.stanley.xie.cleanarchitecturedemo.usecase.RequestRideUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rides")
@AllArgsConstructor
public class RideController {
    private final RequestRideUseCase requestRideUseCase;
    private final AssignDriverUseCase assignDriverUseCase;

    @PostMapping("/request")
    public ResponseEntity<String> requestRide(@RequestBody Map<String, String> request) {
        String passengerId = request.get("passengerId");
        String pickup = request.get("pickup");
        String dropoff = request.get("dropoff");

        String rideId = requestRideUseCase.execute(passengerId, pickup, dropoff);
        return ResponseEntity.ok("Ride requested with ID: " + rideId);
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignDriver(@RequestBody Map<String, String> request) {
        String rideId = request.get("rideId");
        String driverId = request.get("driverId");

        if (assignDriverUseCase.execute(rideId, driverId)) {
            return ResponseEntity.ok("Driver assigned successfully");
        }
        return ResponseEntity.badRequest().body("Driver assignment failed.");
    }
}
