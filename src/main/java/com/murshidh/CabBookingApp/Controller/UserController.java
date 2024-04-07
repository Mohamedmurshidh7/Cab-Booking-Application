package com.murshidh.CabBookingApp.Controller;

import com.murshidh.CabBookingApp.Dto.request.UserRequest;
import com.murshidh.CabBookingApp.Dto.response.UserResponse;
import com.murshidh.CabBookingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody UserRequest userRequest)
    {
        userService.addUser(userRequest);
    }

    @GetMapping("/getAll")
    public List<UserResponse> getAll()
    {
        return userService.getAllUsers();
    }

}
