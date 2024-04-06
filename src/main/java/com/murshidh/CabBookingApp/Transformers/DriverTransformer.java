package com.murshidh.CabBookingApp.Transformers;

import com.murshidh.CabBookingApp.dto.request.DriverRequest;
import com.murshidh.CabBookingApp.model.Driver;
import com.murshidh.CabBookingApp.model.DriverDetails;
import com.murshidh.CabBookingApp.model.VehicleDetails;

public class DriverTransformer {
    public static Driver convertDtoToEntity(DriverRequest driverRequest)
    {
        DriverDetails driverDetails = DriverDetails.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .gender(driverRequest.getGender())
                .build();
        VehicleDetails vehicleDetails = VehicleDetails.builder()
                .carModel(driverRequest.getCarModel())
                .registrationNumber(driverRequest.getRegistrationNumber())
                .build();
        Driver driver = Driver.builder()
                .driverDetails(driverDetails)
                .vehicleDetails(vehicleDetails)
                .isBooked(false)
                .location(driverRequest.getLocation())
                .build();
        return driver;
    }
}
