package com.password.validator.util;

import com.password.validator.exception.PasswordValidationException;

import java.util.ArrayList;
import java.util.List;

/*
@Author: Amirul Amin
This Utility is responsible for validating password strength and conditions
Each failed condition will throw exception
 */
public class PasswordVerifierUtility {

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
                failedExceptions.add("Password should have one upper case letter atleast");
            }
            if (password.chars().anyMatch(Character::isLowerCase))
                successCounter++;
            else {
                failedExceptions.add("Password should have one lower case letter atleast");
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
}
