package com.murshidh.CabBookingApp.Repository;

import com.murshidh.CabBookingApp.Model.Driver;
import com.murshidh.CabBookingApp.Model.DriverDetails;
import com.murshidh.CabBookingApp.Model.Gender;
import com.murshidh.CabBookingApp.Model.VehicleDetails;
import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void initData() {
        // Load initial data into the repository
        driverMap.put("Clark Kent", Driver.builder()
                .driverDetails(DriverDetails
                        .builder()
                        .name("Clark Kent")
                        .age(36)
                        .gender(Gender.M)
                        .build())
                .vehicleDetails(VehicleDetails
                        .builder()
                        .carModel("i20")
                        .registrationNumber("KA-5466666")
                        .build())
                .isBooked(false)
                .location(new int[]{30,40})
                .build());
        driverMap.put("Bruce Wayne", Driver.builder()
                .driverDetails(DriverDetails
                        .builder()
                        .name("Bruce Wayne")
                        .age(32)
                        .gender(Gender.M)
                        .build())
                .vehicleDetails(VehicleDetails
                        .builder()
                        .carModel("Supra")
                        .registrationNumber("KA-7678990")
                        .build())
                .isBooked(false)
                .location(new int[]{20,10})
                .build());
        driverMap.put("Diana Prince", Driver.builder()
                .driverDetails(DriverDetails
                        .builder()
                        .name("Diana Prince")
                        .age(27)
                        .gender(Gender.F)
                        .build())
                .vehicleDetails(VehicleDetails
                        .builder()
                        .carModel("Swift")
                        .registrationNumber("TN-098888")
                        .build())
                .isBooked(false)
                .location(new int[]{0,0})
                .build());
        driverMap.put("Tony Stark", Driver.builder()
                .driverDetails(DriverDetails
                        .builder()
                        .name("Tony Stark")
                        .age(30)
                        .gender(Gender.M)
                        .build())
                .vehicleDetails(VehicleDetails
                        .builder()
                        .carModel("Elevate")
                        .registrationNumber("TS-54669966")
                        .build())
                .isBooked(false)
                .location(new int[]{90,40})
                .build());
        driverMap.put("Peter Parker", Driver.builder()
                .driverDetails(DriverDetails
                        .builder()
                        .name("Peter Parker")
                        .age(20)
                        .gender(Gender.M)
                        .build())
                .vehicleDetails(VehicleDetails
                        .builder()
                        .carModel("AMG")
                        .registrationNumber("KA-500966666")
                        .build())
                .isBooked(false)
                .location(new int[]{20,25})
                .build());
        // Add more initial data if needed
    }

}
