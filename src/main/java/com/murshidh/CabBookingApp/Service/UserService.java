package com.murshidh.CabBookingApp.Service;

import com.murshidh.CabBookingApp.Transformers.UserTransformer;
import com.murshidh.CabBookingApp.Dto.request.UserRequest;
import com.murshidh.CabBookingApp.Model.User;
import com.murshidh.CabBookingApp.Repository.UserRepository;
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
