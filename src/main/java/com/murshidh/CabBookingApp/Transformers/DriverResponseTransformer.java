package com.murshidh.CabBookingApp.Transformers;

import com.murshidh.CabBookingApp.Dto.response.DriverResponse;
import com.murshidh.CabBookingApp.Model.Driver;

public class DriverResponseTransformer {
    public static DriverResponse convertEntityToDto(Driver driver)
    {
        DriverResponse driverResponse = DriverResponse.builder()
                .name(driver.getDriverDetails().getName())
                .age(driver.getDriverDetails().getAge())
                .carModel(driver.getVehicleDetails().getCarModel())
                .location(driver.getLocation())
                .registrationNumber(driver.getVehicleDetails().getRegistrationNumber())
                .build();
        return driverResponse;
    }
}
