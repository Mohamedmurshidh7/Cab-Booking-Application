package com.murshidh.CabBookingApp.repository;

import com.murshidh.CabBookingApp.model.Driver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
@Slf4j
public class DriverRepository {
    HashMap<String,Driver> driverMap = new HashMap<>();

    public Optional<Driver> findByName(String name)
    {
        return Optional.ofNullable(driverMap.get(name));
    }

    public HashMap<String,Driver> findAll()
    {
        return driverMap;
    }

    public void delete(String name)
    {
        if(!driverMap.containsKey(name))
        {
            log.debug("Driver {} not present", name);
            return;
        }
            driverMap.remove(name);
    }

    public void save(Driver driver)
    {
        String driverName = driver.getDriverDetails().getName();
        if(driverMap.containsKey(driverName))
        {
            log.debug("Driver {} already registered", driverName);
            return;
        }
            driverMap.put(driverName,driver);
    }

//    @PostConstruct
//    public void initData() {
//        // Load initial data into the repository
//        driverMap.put("John", new Driver("John", Gender.M));
//        driverMap.put("Jane", new Driver("Jane", Gender.F));
//        // Add more initial data if needed
//    }

}
