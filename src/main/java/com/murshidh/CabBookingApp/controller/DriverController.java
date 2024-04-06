package com.murshidh.CabBookingApp.controller;

import com.murshidh.CabBookingApp.dto.request.DriverRequest;
import com.murshidh.CabBookingApp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public void addDriver(@RequestBody DriverRequest driverRequest){

        driverService.addDriver(driverRequest);
    }






}
