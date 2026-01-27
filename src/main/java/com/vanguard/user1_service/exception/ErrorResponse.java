package com.vanguard.user1_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
@AllArgsConstructor
@Data
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private Map<String, String> fieldErrors; // 👈 for validation

    public ErrorResponse() {
    }



}
