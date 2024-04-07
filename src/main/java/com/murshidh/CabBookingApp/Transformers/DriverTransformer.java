package com.murshidh.CabBookingApp.Transformers;

import com.murshidh.CabBookingApp.Dto.request.DriverRequest;
import com.murshidh.CabBookingApp.Model.Driver;
import com.murshidh.CabBookingApp.Model.DriverDetails;
import com.murshidh.CabBookingApp.Model.VehicleDetails;

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
