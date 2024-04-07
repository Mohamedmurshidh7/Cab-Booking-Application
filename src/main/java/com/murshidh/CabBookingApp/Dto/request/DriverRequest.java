package com.murshidh.CabBookingApp.Dto.request;

import com.murshidh.CabBookingApp.Model.Gender;
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
