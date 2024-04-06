package com.murshidh.CabBookingApp.dto.request;

import com.murshidh.CabBookingApp.model.Gender;
import lombok.Data;

@Data
public class UserRequest {
    String name;
    Gender gender;
    int age;
}
