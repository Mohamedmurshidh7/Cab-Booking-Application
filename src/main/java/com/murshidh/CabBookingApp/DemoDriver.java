package com.murshidh.CabBookingApp;

import com.murshidh.CabBookingApp.Dto.request.DriverRequest;
import com.murshidh.CabBookingApp.Dto.response.DriverResponse;
import com.murshidh.CabBookingApp.Enum.Gender;
import com.murshidh.CabBookingApp.Exception.DriverNotAvailable;
import com.murshidh.CabBookingApp.Service.DriverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DemoDriver {

    @Autowired
    private DriverService driverService;

    public void executeAllCommands() {
        // Execute all commands here
        log.info("Executing 1st use case: ");
        addingDriverNearestToUserLocation();
        log.info("Executing 2nd use case: ");
        fetchingMultipleDriversAndChooseOne();
    }

    /*
    This function adds a driver , gets the driver nearest to user location.
     */
    private void addingDriverNearestToUserLocation() {
        // Simulate adding a driver
        DriverRequest driverRequest = new DriverRequest();
        driverRequest.setAge(25);
        driverRequest.setName("Lucci");
        driverRequest.setGender(Gender.M);
        driverRequest.setLocation(new int[]{6,1});
        driverRequest.setCarModel("Lambo");
        driverRequest.setRegistrationNumber("KL-56448720");
        //adding driver
        driverService.addDriver(driverRequest);

        int[] currentLocation = new int[]{5,4};
        List<DriverResponse> nearestDriverList = driverService.findDrivers(currentLocation);

        //This will be Lucci
        log.info("Nearest Driver: "+ nearestDriverList.get(0).getName());


    }

    /*
    Fetches multiple nearest drivers and choose one,
    if someone chooses the same driver again, it will throw a exception
     */
    private void fetchingMultipleDriversAndChooseOne() {


        int[] currentLocation = new int[]{0,0};
        List<DriverResponse> nearestDriverList = driverService.findDrivers(currentLocation);
        log.info("Nearest Drivers:");
        //This will be "DianaPrince" and "BarryAllen"
        for(DriverResponse driverResponse:nearestDriverList)
        {
            log.info(driverResponse.getName());
        }

        try
        {

        //choose one driver from list
        boolean response = driverService.chooseRide(nearestDriverList.get(0).getName());
        log.info(String.valueOf(response));
        }
        catch (DriverNotAvailable exception)
        {
            log.info(exception.getMessage());
        }

        //If we try to book the same driver again, it will throw a exception
        try
        {

            //choose one driver from list
            boolean response = driverService.chooseRide(nearestDriverList.get(0).getName());
            log.info(String.valueOf(response));
        }
        catch (DriverNotAvailable exception)
        {
            log.info(exception.getMessage());
        }


    }
}
