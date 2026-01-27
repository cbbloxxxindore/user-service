package com.vanguard.user1_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
public class UserCreateRequest {


        @NotBlank(message = "Name is mandatory")
        private String name;

        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is mandatory")
        private String email;

        @NotNull(message = "Age is required")
        private Integer age;

        @Size(min = 8, message = "Password must be at least 8 characters")
        private String password;

    }


