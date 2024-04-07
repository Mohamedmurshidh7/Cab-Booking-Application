package com.murshidh.CabBookingApp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    DriverDetails driverDetails;
    VehicleDetails vehicleDetails;
    int[] location;
    boolean isBooked = false;
}
