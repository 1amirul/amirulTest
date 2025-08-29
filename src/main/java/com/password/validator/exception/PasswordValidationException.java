package com.password.validator.exception;

import java.util.List;

public class PasswordValidationException extends RuntimeException {
    public PasswordValidationException(List<String> msg) {
        super(String.join(": ", msg));
    }
}
