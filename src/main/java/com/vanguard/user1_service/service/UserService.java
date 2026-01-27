package com.vanguard.user1_service.service;


import com.vanguard.user1_service.dto.UserCreateRequest;
import com.vanguard.user1_service.models.User;

public interface UserService {


    User createUser(UserCreateRequest request);

    User getUserById(Long id);
}
