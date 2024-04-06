package com.murshidh.CabBookingApp.dto.request;

import com.murshidh.CabBookingApp.model.Gender;
import lombok.Data;

@Data
public class DriverRequest {
    String name;
    int age;
    Gender gender;
    String carModel;
    String registrationNumber;
    int[] location;
}
