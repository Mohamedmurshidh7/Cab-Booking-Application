package com.murshidh.CabBookingApp.Dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverResponse {
    String name;
    int age;
    String carModel;
    String registrationNumber;
    int[] location;
}
