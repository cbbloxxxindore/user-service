package com.vanguard.user1_service.resource;

import com.vanguard.user1_service.dto.UserCreateRequest;
import com.vanguard.user1_service.models.User;
import com.vanguard.user1_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }
}
