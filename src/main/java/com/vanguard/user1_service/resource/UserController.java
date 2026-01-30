package com.vanguard.user1_service.resource;

import com.vanguard.user1_service.dto.UserCreateRequest;
import com.vanguard.user1_service.models.User;
import com.vanguard.user1_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(
            @Valid @RequestBody UserCreateRequest request) {

        log.info("Create User API called");
        log.debug("Create User request payload: name={}, email={}",
                request.getName(), request.getEmail());

        User user = userService.createUser(request);

        log.info("User created successfully with id={}", user.getId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {

        log.info("Get User API called with id={}", id);

        User user = userService.getUserById(id);

        log.info("User fetched successfully with id={}", id);

        return ResponseEntity.ok(user);
    }
}
