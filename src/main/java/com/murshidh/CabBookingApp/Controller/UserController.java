package com.murshidh.CabBookingApp.Controller;

import com.murshidh.CabBookingApp.Dto.request.UserRequest;
import com.murshidh.CabBookingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
