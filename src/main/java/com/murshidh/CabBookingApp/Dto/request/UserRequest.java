package com.murshidh.CabBookingApp.Dto.request;

import com.murshidh.CabBookingApp.Model.Gender;
import lombok.Data;

@Data
public class UserRequest {
    String name;
    Gender gender;
    int age;
}
