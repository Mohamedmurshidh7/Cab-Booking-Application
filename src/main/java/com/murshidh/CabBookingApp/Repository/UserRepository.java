package com.murshidh.CabBookingApp.Repository;

import com.murshidh.CabBookingApp.Model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Slf4j
@Repository
public class UserRepository {
    HashMap<String, User> userMap = new HashMap<>();

    public Optional<User> findByName(String name)
    {
        return Optional.ofNullable(userMap.get(name));
    }

    public HashMap<String,User> findAll()
    {
        return userMap;
    }

    public void delete(String name)
    {
        if(!userMap.containsKey(name))
        {
            log.debug("User {} not present", name);
            return;
        }
            userMap.remove(name);
    }

    public void save(User user)
    {
        String UserName = user.getName();
        if(userMap.containsKey(UserName))
        {
            log.debug("User {} already registered", UserName);
            return;
        }
            userMap.put(UserName,user);
    }
}
