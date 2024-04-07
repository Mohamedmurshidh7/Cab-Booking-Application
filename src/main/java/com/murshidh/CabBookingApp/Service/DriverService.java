package com.murshidh.CabBookingApp.Service;

import com.murshidh.CabBookingApp.Dto.request.DriverRequest;
import com.murshidh.CabBookingApp.Dto.response.DriverResponse;
import com.murshidh.CabBookingApp.Exception.DriverNotAvailable;
import com.murshidh.CabBookingApp.Model.Driver;
import com.murshidh.CabBookingApp.Repository.DriverRepository;
import com.murshidh.CabBookingApp.Transformers.DriverResponseTransformer;
import com.murshidh.CabBookingApp.Transformers.DriverTransformer;
import com.murshidh.CabBookingApp.Util.DistanceCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Value("${MaxDistance:5}")
    private int maxDistance;

    public void addDriver(DriverRequest driverRequest)
    {
        Driver driver = DriverTransformer.convertDtoToEntity(driverRequest);
        driverRepository.save(driver);
    }

    public boolean chooseRide(String name) throws DriverNotAvailable
    {
        Optional<Driver> driver= driverRepository.findByName(name);
        if(driver.isEmpty())
        {
            throw new DriverNotAvailable("No driver with the given name");
        }
        Driver currentDriver = driver.get();
        if(currentDriver.isBooked())
        {
            throw new DriverNotAvailable(currentDriver.getDriverDetails().getName() + " is already in another ride");

        }
        currentDriver.setBooked(true);
        return true;
    }

    /*
    Returns List of drivers nearest to the location
     */
    public List<DriverResponse> findDrivers(int[] location)
    {
        Map<String, Driver> allDrivers = driverRepository.findAll();
        List<DriverResponse> availableDrivers = new ArrayList<>();
        for(Driver driver: allDrivers.values())
        {
            int distanceBetween = DistanceCalculator.calculateDistance(location, driver.getLocation());
            if( distanceBetween<maxDistance && !driver.isBooked())
            {
                DriverResponse driverResponse = DriverResponseTransformer.convertEntityToDto(driver);
                availableDrivers.add(driverResponse);
            }
        }
        //Logic to sort based on the nearest driver
        Collections.sort(availableDrivers,
                (a,b)->{
                int distA = DistanceCalculator.calculateDistance(a.getLocation(),location);
                int distB = DistanceCalculator.calculateDistance(b.getLocation(),location);
                return distA-distB;
                });
        return availableDrivers;
    }
    public List<DriverResponse> findAllDrivers()
    {
        Map<String, Driver> allDriversMap = driverRepository.findAll();
        List<DriverResponse> allDrivers = new ArrayList<>();
        for(Driver driver: allDriversMap.values())
        {
            DriverResponse driverResponse = DriverResponseTransformer.convertEntityToDto(driver);
            allDrivers.add(driverResponse);
        }

        return allDrivers;
    }

}
