package com.murshidh.CabBookingApp.Model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
    M,
    F;
    @JsonCreator
    public static Gender fromString(String value) {
        return valueOf(value.toUpperCase());
    }
}
