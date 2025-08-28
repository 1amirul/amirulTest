package com.test;

import com.test.exception.PasswordNullException;
import com.test.util.PasswordVerifierUtility;

public class PasswordValidatorApplication {
    public static void main(String[] args) {
        String password = null;
        PasswordVerifierUtility.TimeDelayProvider delay = () -> {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex){
                System.out.println(" Interrupted exception occurred");
            }
        };
        PasswordVerifierUtility verifierUtility = new PasswordVerifierUtility(delay);
        try {
            String message = verifierUtility.passwordVerifier(password);
        } catch(PasswordNullException ex) {
            System.out.println("Verification failed with message :"+ ex.getMessage());
        }
    }
}