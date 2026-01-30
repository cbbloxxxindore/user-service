package com.vanguard.user1_service.service;

import com.vanguard.user1_service.dto.UserCreateRequest;
import com.vanguard.user1_service.exception.UserNotFoundException;
import com.vanguard.user1_service.models.User;
import com.vanguard.user1_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreateRequest request) {

        log.debug("Creating user with email={}", request.getEmail());

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        user.setPassword(request.getPassword()); // later encrypt

        User savedUser = userRepository.save(user);

        log.info("User saved successfully with id={}", savedUser.getId());

        return savedUser;
    }

    @Override
    public User getUserById(Long id) {

        log.debug("Fetching user from DB with id={}", id);

        return userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("User not found with id={}", id);
                    return new UserNotFoundException(
                            "User not found with id: " + id);
                });
    }
}
