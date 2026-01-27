package com.vanguard.user1_service.service;

import com.vanguard.user1_service.dto.UserCreateRequest;
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

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        return userRepository.save(user);
    }
}
