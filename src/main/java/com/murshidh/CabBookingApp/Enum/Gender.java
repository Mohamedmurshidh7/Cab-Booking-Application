package com.murshidh.CabBookingApp.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Gender {
    M,
    F;
    @JsonCreator
    public static Gender fromString(String value) {
        return valueOf(value.toUpperCase());
    }
}
