package com.test.util;

import com.test.exception.PasswordNullException;

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
                provider.delay();
                failedExceptions.add("Password should be larger than 8 characters");
            }
            if(password.chars().anyMatch(Character:: isUpperCase))
                successCounter++;
            else {
                provider.delay();
                failedExceptions.add("Password should have one upper case letter atleast");
            }
            if(password.chars().anyMatch(Character:: isLowerCase))
                successCounter++;
            else {
                provider.delay();
                failedExceptions.add("Password should have one lower case letter atleast");
                failedExceptions.forEach(msg -> System.out.println(" "+msg));
                return "Password is never OK";
            }
            if(password.chars().anyMatch(Character:: isDigit))
                successCounter++;
            else {
                provider.delay();
                failedExceptions.add("Password should have one number atleast");
            }
            if (successCounter>=3)
                return "Password is OK";
            else {
                failedExceptions.forEach(msg -> System.out.println(" "+msg));
                return "Password is never OK";
            }
        }
        failedExceptions.add("Password should not be null");
        throw new PasswordNullException("Password should not be null");
        //return "Password is never OK";

    }

    public interface TimeDelayProvider {
        void delay();
    }
}
