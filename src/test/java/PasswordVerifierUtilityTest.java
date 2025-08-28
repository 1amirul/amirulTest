import com.test.util.PasswordVerifierUtility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordVerifierUtilityTest {

    private final PasswordVerifierUtility.TimeDelayProvider noDelay =() -> {};

    private final PasswordVerifierUtility verifierUtility = new PasswordVerifierUtility(noDelay);

    @Test
    void testPasswordOk(){
        String password = "Test@1234";
        String message = verifierUtility.passwordVerifier(password);
        Assertions.assertEquals("Password is OK",message);

    }

}
