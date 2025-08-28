package com.test;

import com.test.exception.PasswordNullException;
import com.test.util.PasswordVerifierUtility;

public class PasswordValidatorApplication {
    public static void main(String[] args) {
        String password = "Test1234";
        PasswordVerifierUtility.TimeDelayProvider delay = () -> {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex){
                System.out.println(" Interrupted exception occurred"+ex.getMessage());
            }
        };
        PasswordVerifierUtility verifierUtility = new PasswordVerifierUtility(delay);
        try {
            String message = verifierUtility.passwordVerifier(password);
            System.out.println(message);
        } catch(PasswordNullException ex) {
            System.out.println("Verification failed with message :"+ ex.getMessage());
        }
    }
}