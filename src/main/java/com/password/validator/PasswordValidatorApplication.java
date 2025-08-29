package com.password.validator;

import com.password.validator.exception.PasswordValidationException;
import com.password.validator.util.PasswordVerifierUtility;

/*
This is main class of the password validation app
 */
public class PasswordValidatorApplication {
    public static void main(String[] args) {
        String password = "Test12345";

        PasswordVerifierUtility verifierUtility = new PasswordVerifierUtility();
        try {
            String message = verifierUtility.passwordVerifier(password);
            System.out.println(message);
        } catch(PasswordValidationException ex) {
            System.out.println("Verification failed with message :"+ ex.getMessage());
        }
    }
}