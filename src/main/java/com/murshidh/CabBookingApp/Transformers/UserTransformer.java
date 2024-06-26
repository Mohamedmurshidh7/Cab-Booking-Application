package com.murshidh.CabBookingApp.Transformers;

import com.murshidh.CabBookingApp.Dto.request.UserRequest;
import com.murshidh.CabBookingApp.Model.User;

public class UserTransformer {
    public static User convertDtoToEntity(UserRequest userRequest)
    {

        User user = User.builder()
                .name(userRequest.getName())
                .gender(userRequest.getGender())
                .age(userRequest.getAge())
                .build();
        return user;
    }
}
