import com.password.validator.exception.PasswordValidationException;
import com.password.validator.util.PasswordVerifierUtility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
This is junit test class for password verifier
 */
public class PasswordVerifierUtilityTest {

    /*
    To run test case faster we have added as no delay
     */
    private final PasswordVerifierUtility.TimeDelayProvider noDelay =() -> {};

    private final PasswordVerifierUtility verifierUtility = new PasswordVerifierUtility(noDelay);

    /*
    Test positive scenario when Password is OK

     */
    @Test
    void testPasswordOk(){
        String password = "Test@1234";
        String message = verifierUtility.passwordVerifier(password);
        Assertions.assertEquals("Password is OK",message);

    }

    /*
    Test positive scenario when 3 conditions have passed
     */
    @Test
    void testPasswordOkIfAnyThreeConditionPassed(){
        String password = "Test";
        String message = verifierUtility.passwordVerifier(password);
        Assertions.assertEquals("Password is OK",message);

    }

    /*
    Test negative scenario when password does not have lower case
     */
    @Test
    void testPasswordNotOkIfNoLowerCase(){
        String password = "TEST@1234";
        Exception exception = Assertions.assertThrows(PasswordValidationException.class, () -> {
            verifierUtility.passwordVerifier(password);
        });
        Assertions.assertTrue(exception.getMessage().contains("Password should have one lower case letter atleast"));
    }

    /*
    Test negative scenario when password does not have upper case and no digit
     */
    @Test
    void testPasswordNotOkIfNoUpperCaseNoDigit(){
        String password = "est";
        Exception exception = Assertions.assertThrows(PasswordValidationException.class, () -> {
            verifierUtility.passwordVerifier(password);
        });
        Assertions.assertTrue(exception.getMessage().contains("Password should have one number atleast"));
        Assertions.assertTrue(exception.getMessage().contains("Password should have one upper case letter atleast"));
    }

    /*
    Test negative scenario when password is null
     */
    @Test
    void testPasswordThrowsExceptionIfNull(){
        String password = null;
        Exception exception = Assertions.assertThrows(PasswordValidationException.class, () -> {
            verifierUtility.passwordVerifier(password);
        });
        Assertions.assertTrue(exception.getMessage().contains("Password should not be null"));
    }
}
