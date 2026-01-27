package com.vanguard.user1_service.repository;

import com.vanguard.user1_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<com.vanguard.user1_service.models.User, Long> {

    Optional<User> findByEmail(String email);
}
