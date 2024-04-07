package com.murshidh.CabBookingApp.Model;

import com.murshidh.CabBookingApp.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String name;
    Gender gender;
    int age;
}
