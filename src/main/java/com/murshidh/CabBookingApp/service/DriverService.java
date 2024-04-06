package com.murshidh.CabBookingApp.service;

import com.murshidh.CabBookingApp.Transformers.DriverTransformer;
import com.murshidh.CabBookingApp.dto.request.DriverRequest;
import com.murshidh.CabBookingApp.model.Driver;
import com.murshidh.CabBookingApp.repository.DriverRepository;
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
        HashMap<String, Driver> allDrivers = driverRepository.findAll();
        if(!allDrivers.containsKey(name))
        {
            log.debug("No Driver with the given name");
            return false;
        }
        Driver currentDriver = allDrivers.get(name);
        if(currentDriver.isBooked())
        {
            log.debug("Driver {} is not available", currentDriver.getDriverDetails().getName());
            return false;
        }
        currentDriver.setBooked(true);
        return true;
    }

    public List<Driver> findDrivers(int[] location)
    {
        HashMap<String, Driver> allDrivers = driverRepository.findAll();
        List<Driver> availableDrivers = new ArrayList<>();
        for(Map.Entry<String,Driver> data: allDrivers.entrySet())
        {
            String name = data.getKey();
            Driver driver = data.getValue();
            if( ((Math.abs(location[0]-driver.getLocation()[0])<5)
            && (Math.abs(location[1]-driver.getLocation()[1])<5)) && !driver.isBooked())
            {
                availableDrivers.add(driver);
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

}
