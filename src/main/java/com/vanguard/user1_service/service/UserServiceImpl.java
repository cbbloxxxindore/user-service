package com.vanguard.user1_service.service;

import com.vanguard.user1_service.dto.UserCreateRequest;
import com.vanguard.user1_service.exception.UserNotFoundException;
import com.vanguard.user1_service.models.User;
import com.vanguard.user1_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreateRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        user.setPassword(request.getPassword()); // later encrypt

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }}

