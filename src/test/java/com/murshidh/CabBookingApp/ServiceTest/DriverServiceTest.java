package com.murshidh.CabBookingApp.ServiceTest;

import com.murshidh.CabBookingApp.Dto.request.DriverRequest;
import com.murshidh.CabBookingApp.Dto.response.DriverResponse;
import com.murshidh.CabBookingApp.Enum.Gender;
import com.murshidh.CabBookingApp.Exception.DriverNotAvailable;
import com.murshidh.CabBookingApp.Model.Driver;
import com.murshidh.CabBookingApp.Model.DriverDetails;
import com.murshidh.CabBookingApp.Model.VehicleDetails;
import com.murshidh.CabBookingApp.Repository.DriverRepository;
import com.murshidh.CabBookingApp.Service.DriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DriverServiceTest {
    @InjectMocks    //@InjectMocks is used to inject the UserService instance.
    private DriverService driverService;

    @Mock           // @Mock is used to mock the UserRepository.
    private DriverRepository driverRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);    // MockitoAnnotations.initMocks(this) is used to initialize the mocks.
    }

    @Test
    public void testAddDriver() {
        // Create a sample AddUserDto
        DriverRequest driverRequest = new DriverRequest();
        driverRequest.setAge(25);
        driverRequest.setName("Test Driver");
        driverRequest.setGender(Gender.M);
        driverRequest.setLocation(new int[]{6,1});
        driverRequest.setCarModel("Demo car");
        driverRequest.setRegistrationNumber("KL-56448720");

        driverService.addDriver(driverRequest);

        //verifying if save method gets called
        Mockito.verify(driverRepository,Mockito.times(1)).save(Mockito.any(Driver.class));
    }

    @Test
    public void testChooseRide() throws DriverNotAvailable {
        Driver driver = new Driver();
        driver.setBooked(false);

        Optional<Driver> optionalDriver = Optional.of(driver);

        Mockito.when(driverRepository.findByName("TestDriver")).thenReturn(optionalDriver);

        assertTrue(driverService.chooseRide("TestDriver"));
        assertTrue(driver.isBooked());
    }
    @Test
    public void testFindDrivers() {
        int[] location = {0, 0};

        Driver driver1 = Driver.builder()
                .driverDetails(DriverDetails.builder()
                        .name("driver1")
                        .build())
                .vehicleDetails(VehicleDetails.builder()
                        .build())
                .isBooked(false)
                .location(new int[] {1, 1})
                .build();

        Driver driver2 = Driver.builder()
                .driverDetails(DriverDetails.builder()
                        .name("driver2")
                        .build())
                .vehicleDetails(VehicleDetails.builder()
                        .build())
                .isBooked(false)
                .location(new int[] {2, 2})
                .build();
        //Driver is more than 5 blocks away
        Driver driver3 = Driver.builder()
                .driverDetails(DriverDetails.builder()
                        .name("driver3")
                        .build())
                .vehicleDetails(VehicleDetails.builder()
                        .build())
                .isBooked(false)
                .location(new int[] {6,3})
                .build();


        Map<String, Driver> allDrivers = Map.of("driver1", driver1, "driver2", driver2,"driver3", driver3);

        Mockito.when(driverRepository.findAll()).thenReturn(allDrivers);
        ReflectionTestUtils.setField(driverService,"maxDistance",5);
        List<DriverResponse> result = driverService.findDrivers(location);
        //Only two drivers are near
        assertEquals(2, result.size());
    }


}
