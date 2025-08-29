package com.password.validator;

import com.password.validator.exception.PasswordValidationException;
import com.password.validator.util.PasswordVerifierUtility;

/*
This is main class of the password validation app
 */
public class PasswordValidatorApplication {
    public static void main(String[] args) {
        String password = "Test12345";
        PasswordVerifierUtility.TimeDelayProvider delay = () -> {
            try {
                Thread.sleep(1000); // Delay of 1 second to verify password
            } catch(InterruptedException ex){
                System.out.println(" Interrupted exception occurred"+ex.getMessage());
            }
        };
        PasswordVerifierUtility verifierUtility = new PasswordVerifierUtility(delay);
        try {
            String message = verifierUtility.passwordVerifier(password);
            System.out.println(message);
        } catch(PasswordValidationException ex) {
            System.out.println("Verification failed with message :"+ ex.getMessage());
        }
    }
}