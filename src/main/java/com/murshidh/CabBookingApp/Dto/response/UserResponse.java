package com.murshidh.CabBookingApp.Dto.response;

import com.murshidh.CabBookingApp.Enum.Gender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    String name;
    Gender gender;
    int age;
}
