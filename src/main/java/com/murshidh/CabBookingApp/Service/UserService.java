package com.murshidh.CabBookingApp.Service;

import com.murshidh.CabBookingApp.Dto.request.UserRequest;
import com.murshidh.CabBookingApp.Dto.response.UserResponse;
import com.murshidh.CabBookingApp.Model.User;
import com.murshidh.CabBookingApp.Repository.UserRepository;
import com.murshidh.CabBookingApp.Transformers.UserResponseTransformer;
import com.murshidh.CabBookingApp.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public List<UserResponse> getAllUsers()
    {
        Map<String,User> userMap =  userRepository.findAll();
        List<UserResponse> ans = new ArrayList<>();
        for(User u: userMap.values())
        {
            ans.add(UserResponseTransformer.convertEntityToDto(u));
        }
       return ans;
    }


}
