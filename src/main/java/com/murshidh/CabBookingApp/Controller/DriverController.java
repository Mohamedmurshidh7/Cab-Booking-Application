package com.murshidh.CabBookingApp.Controller;

import com.murshidh.CabBookingApp.Dto.request.DriverRequest;
import com.murshidh.CabBookingApp.Dto.response.DriverResponse;
import com.murshidh.CabBookingApp.Exception.DriverNotAvailable;
import com.murshidh.CabBookingApp.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("/add")
    public void addDriver(@RequestBody DriverRequest driverRequest){

        driverService.addDriver(driverRequest);
    }

    @GetMapping("/findRide")
    public List<DriverResponse> findRide(@RequestParam String name, @RequestParam int[] source, @RequestParam int[] destination)
    {
        return driverService.findDrivers(source);
    }

    @GetMapping("/findAllDrivers")
    public List<DriverResponse> findAllDrivers()
    {
        return driverService.findAllDrivers();
    }

    @PutMapping("/chooseRide/{driverName}")
    public boolean chooseRide(@PathVariable String driverName) throws DriverNotAvailable
    {
        return driverService.chooseRide(driverName);
    }









}
