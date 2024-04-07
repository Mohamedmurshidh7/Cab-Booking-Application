package com.murshidh.CabBookingApp.Dto.request;

import com.murshidh.CabBookingApp.Enum.Gender;
import lombok.Data;

@Data
public class UserRequest {
    String name;
    Gender gender;
    int age;
}
