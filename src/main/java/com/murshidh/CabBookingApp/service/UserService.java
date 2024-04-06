package com.murshidh.CabBookingApp.service;

import com.murshidh.CabBookingApp.Transformers.UserTransformer;
import com.murshidh.CabBookingApp.dto.request.UserRequest;
import com.murshidh.CabBookingApp.model.User;
import com.murshidh.CabBookingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean addUser(UserRequest userRequest)
    {
        User user  = UserTransformer.convertDtoToEntity(userRequest);
        userRepository.save(user);
        return true;
    }

}
