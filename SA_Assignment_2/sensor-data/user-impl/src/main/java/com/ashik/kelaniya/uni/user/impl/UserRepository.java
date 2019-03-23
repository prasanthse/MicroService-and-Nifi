package com.ashik.kelaniya.uni.user.impl;

import com.ashik.kelaniya.uni.user.api.User;
import com.google.inject.ImplementedBy;

@ImplementedBy(InMemoryUserRepository.class)
public interface UserRepository {
    User getUser(String id);
    void save(User user);
}
