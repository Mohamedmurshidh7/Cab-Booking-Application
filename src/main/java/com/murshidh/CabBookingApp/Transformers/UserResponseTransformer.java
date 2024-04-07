package com.murshidh.CabBookingApp.Transformers;

import com.murshidh.CabBookingApp.Dto.response.UserResponse;
import com.murshidh.CabBookingApp.Model.User;

public class UserResponseTransformer {
    public static UserResponse convertEntityToDto(User user)
    {
        UserResponse userResponse  = UserResponse.builder()
                .name(user.getName())
                .gender(user.getGender())
                .age(user.getAge())
                .build();
        return userResponse;
    }

}
