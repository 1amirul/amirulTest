package com.password.validator.util;

import com.password.validator.exception.PasswordValidationException;

import java.util.ArrayList;
import java.util.List;

public class PasswordVerifierUtility {

    private final TimeDelayProvider provider;

    public PasswordVerifierUtility(TimeDelayProvider provider){
        this.provider = provider;
    }

    public String passwordVerifier(String password) {
        List<String> failedExceptions= new ArrayList<>();
        int successCounter = 0;
        if(password!=null) {
            successCounter++;
            if (password.length() > 8)
                successCounter++;
            else {
                failedExceptions.add("Password should be larger than 8 characters");
            }
            if (password.chars().anyMatch(Character::isUpperCase))
                successCounter++;
            else {
                provider.delay();
                failedExceptions.add("Password should have one upper case letter atleast");
            }
            if (password.chars().anyMatch(Character::isLowerCase))
                successCounter++;
            else {
                provider.delay();
                failedExceptions.add("Password should have one lower case letter atleast");
                failedExceptions.forEach(msg -> System.out.println(" " + msg));
                throw new PasswordValidationException(failedExceptions);
            }
            if (password.chars().anyMatch(Character::isDigit))
                successCounter++;
            else {
                failedExceptions.add("Password should have one number atleast");
            }
            if (successCounter >= 3)
                return "Password is OK";
            else {
                throw new PasswordValidationException(failedExceptions);
            }
        }
        failedExceptions.add("Password should not be null");
        throw new PasswordValidationException(failedExceptions);

    }

    public interface TimeDelayProvider {
        void delay();
    }
}
