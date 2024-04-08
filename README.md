# Cab-Booking-Application
This is a Cab-Booking-Application using Spring Boot.

# Features:
- User can register themselves
- This application allows users to book rides in route.
- Driving Partner can onboard on the system with vehicle details
- Users can search and select one from multiple available rides on a route with the same source based on the nearest to the user.

# Basic Requirements:
- Application allows user onboarding.
    - add_user(user_detail)
        - Add basic user details
- Application allows Driver onboarding
  - add_driver(driver_details,vehicle_details,current_location)
    - This will create an instance of the driver and will mark his current location on the map      
- Application allows the user to find a ride based on the criteria below
  - find_ride (Username,Source , destination)
    - It will return a list of available ride
  - choose_ride(Username,drive_name)
    - It will choose the drive name from the list 
  
These Basic requirements are implemented.

# Key Features and Design Decisions:

- Followed the Spring Boot naming conventions.
- Modularized the code for easier readability. 
- Segregated each layers separately such as Model, Controller and Service.
- Usage of Data Transfer Objects(Dto) for Abstraction, 
  - Example - Instead of using a **Driver** class, I used **DriverResponse** dto to hide some internal fields such as **isBooked**.
- With interest of assignment scope, I used ConcurrentHashMap for storing data and used the names as key for faster retrieval.
- Used ConcurrentHashMap for concurrency handling.
- used **Gender** as enum, since it is common for both **User** and **Driver** class.  
- Externalized maxDistance variable, that is used to find the nearest rides.
- When user gets the nearest rides, it wil be sorted based on the distance from the nearest to farthest ride.
- Created a custom Exception when a driver is not available.
- Distance Calculator inside the Util package is used to calculate the distance between two points.
- Added Unit tests for Driver Service, Similarly we can add UTs for others also.
- Loaded initial data in the HashMap for easier testing.
- Added a DemoDriver component, to run some expected use cases.


Feel free to reach out for any suggestions and improvements.

**Note: import Cab_Booking_Application.postman_collection in Postman for easier testing.** 


