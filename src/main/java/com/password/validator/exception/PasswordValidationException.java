package com.password.validator.exception;

import java.util.List;

/*
Custom exception for password validation messages
 */
public class PasswordValidationException extends RuntimeException {
    public PasswordValidationException(List<String> msg) {
        super(String.join(": ", msg));
    }
}
