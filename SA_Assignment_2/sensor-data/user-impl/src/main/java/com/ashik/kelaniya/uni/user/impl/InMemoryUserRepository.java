package com.ashik.kelaniya.uni.user.impl;

import com.ashik.kelaniya.uni.user.api.User;

import java.util.HashMap;
import java.util.Map;
public class InMemoryUserRepository implements UserRepository{
    Map<String, User> userMap=new HashMap<>();

    public InMemoryUserRepository(){
        User user1 = new User();
        user1.setId("1");
        user1.setName("Kamal");
        user1.setNotificationChannel("Email");

        userMap.put("1",user1);
    }
    @Override
    public User getUser(String id) {
        if(userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    @Override
    public void save(User user) {
        userMap.put(user.getId(),user);
    }
}
