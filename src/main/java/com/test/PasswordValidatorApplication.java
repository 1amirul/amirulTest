package com.test;

import com.test.util.PasswordVerifierUtility;

public class PasswordValidatorApplication {
    public static void main(String[] args) {
        String password = "Test@1234";
        PasswordVerifierUtility.TimeDelayProvider delay = () -> {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex){
                System.out.println(" Interrupted exception occurred");
            }
        };
        PasswordVerifierUtility verifierUtility = new PasswordVerifierUtility(delay);
        String message = verifierUtility.passwordVerifier(password);
        System.out.println(message);
    }
}