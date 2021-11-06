package com.example.application.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ErrorResponse {
    private String path;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }
}