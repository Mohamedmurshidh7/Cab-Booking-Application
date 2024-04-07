package com.murshidh.CabBookingApp.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverDetails {
    String name;
    Gender gender;
    int age;
}
