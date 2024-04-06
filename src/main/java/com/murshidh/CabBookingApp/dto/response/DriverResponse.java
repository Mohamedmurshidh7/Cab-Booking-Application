package com.murshidh.CabBookingApp.dto.response;

import lombok.Data;

@Data
public class DriverResponse {
    String name;
    int age;
    String carMode;
    String registrationNumber;
    int[] location;
}
