package com.stanley.xie.cleanarchitecturedemo.infrastructure;

import com.stanley.xie.cleanarchitecturedemo.entity.Driver;
import com.stanley.xie.cleanarchitecturedemo.entity.DriverRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDriverRepository implements DriverRepository {
    private Map<String, Driver> drivers = new HashMap<>();

    @Override
    public boolean isAvailable(String driverId) {
        Driver driver = drivers.get(driverId);
        return driver.isAvailable();
    }
}
