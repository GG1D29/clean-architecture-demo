package com.stanley.xie.cleanarchitecturedemo;

import com.stanley.xie.cleanarchitecturedemo.adapter.RideController;
import com.stanley.xie.cleanarchitecturedemo.entity.DriverRepository;
import com.stanley.xie.cleanarchitecturedemo.entity.RideRepository;
import com.stanley.xie.cleanarchitecturedemo.infrastructure.InMemoryDriverRepository;
import com.stanley.xie.cleanarchitecturedemo.infrastructure.InMemoryRideRepository;
import com.stanley.xie.cleanarchitecturedemo.usecase.AssignDriverUseCase;
import com.stanley.xie.cleanarchitecturedemo.usecase.RequestRideUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RideSharingApp {

    public static void main(String[] args) {
        SpringApplication.run(RideSharingApp.class, args);
    }

    @Bean
    public RideRepository rideRepository() {
        return new InMemoryRideRepository();
    }

    @Bean
    public DriverRepository driverRepository() {
        return new InMemoryDriverRepository();
    }

    @Bean
    public RequestRideUseCase requestRideUseCase(RideRepository rideRepository) {
        return new RequestRideUseCase(rideRepository);
    }

    @Bean
    public AssignDriverUseCase assignDriverUseCase(RideRepository rideRepository, DriverRepository driverRepository) {
        return new AssignDriverUseCase(rideRepository, driverRepository);
    }

    @Bean
    public RideController rideController(RequestRideUseCase requestRideUseCase, AssignDriverUseCase assignDriverUseCase) {
        return new RideController(requestRideUseCase, assignDriverUseCase);
    }
}
