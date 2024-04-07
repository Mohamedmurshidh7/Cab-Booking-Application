package com.murshidh.CabBookingApp.Service;

import com.murshidh.CabBookingApp.Transformers.DriverTransformer;
import com.murshidh.CabBookingApp.Dto.request.DriverRequest;
import com.murshidh.CabBookingApp.Dto.response.DriverResponse;
import com.murshidh.CabBookingApp.Model.Driver;
import com.murshidh.CabBookingApp.Repository.DriverRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public void addDriver(DriverRequest driverRequest)
    {
        Driver driver = DriverTransformer.convertDtoToEntity(driverRequest);
        driverRepository.save(driver);
    }

    public boolean chooseRide(String name)
    {
        Optional<Driver> driver= driverRepository.findByName(name);
        if(driver.isEmpty())
        {
            log.debug("No Driver with the given name");
            return false;
        }
        Driver currentDriver = driver.get();
        if(currentDriver.isBooked())
        {
            log.debug("Driver {} is not available", currentDriver.getDriverDetails().getName());
            return false;
        }
        currentDriver.setBooked(true);
        return true;
    }

    public List<DriverResponse> findDrivers(int[] location)
    {
        HashMap<String, Driver> allDrivers = driverRepository.findAll();
        List<DriverResponse> availableDrivers = new ArrayList<>();
        for(Map.Entry<String,Driver> data: allDrivers.entrySet())
        {
            String name = data.getKey();
            Driver driver = data.getValue();
            if( ((Math.abs(location[0]-driver.getLocation()[0])<5)
            && (Math.abs(location[1]-driver.getLocation()[1])<5)) && !driver.isBooked())
            {
                DriverResponse driverResponse = DriverResponse.builder()
                        .name(driver.getDriverDetails().getName())
                        .age(driver.getDriverDetails().getAge())
                        .carModel(driver.getVehicleDetails().getCarModel())
                        .location(driver.getLocation())
                        .registrationNumber(driver.getVehicleDetails().getRegistrationNumber())
                        .build();
                availableDrivers.add(driverResponse);
            }
        }
        //Logic to sort based on the nearest driver
        Collections.sort(availableDrivers,
                (a,b)->{
                int distA = Math.abs(a.getLocation()[0]- location[0])+ Math.abs(a.getLocation()[1]- location[1]) ;
                int distB = Math.abs(b.getLocation()[0]- location[0])+ Math.abs(b.getLocation()[1]- location[1]);
                return distA-distB;
                });
        return availableDrivers;
    }
    public List<DriverResponse> findAllDrivers()
    {
        HashMap<String, Driver> allDriversMap = driverRepository.findAll();
        List<DriverResponse> allDrivers = new ArrayList<>();
        for(Map.Entry<String,Driver> data: allDriversMap.entrySet())
        {
            String name = data.getKey();
            Driver driver = data.getValue();

                DriverResponse driverResponse = DriverResponse.builder()
                        .name(driver.getDriverDetails().getName())
                        .age(driver.getDriverDetails().getAge())
                        .carModel(driver.getVehicleDetails().getCarModel())
                        .location(driver.getLocation())
                        .registrationNumber(driver.getVehicleDetails().getRegistrationNumber())
                        .build();
                allDrivers.add(driverResponse);

        }

        return allDrivers;
    }

}
