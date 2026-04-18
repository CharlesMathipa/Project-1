/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginTest;

/**
 *
 * @author PC
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.mycompany.userinputout.Login;

public class LoginTest {

    // Instantiate the Login class to test its methods
    Login login = new Login();

    @Test
    public void testCheckUserNameCorrect() {
        // Tests a valid username containing an underscore and <= 5 characters
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrect() {
        // Tests an invalid username that is more than 5 characters long
        assertFalse(login.checkUserName("kyle_12345"));
    }

    @Test
    public void testCheckPasswordComplexitySuccess() {
        // Tests a valid password meeting all complexity rules
        assertTrue(login.checkPasswordComplexity("Ch@tt3r2023!"));
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        // Tests an invalid password lacking numbers, special characters, and uppercase letters
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testPhoneNumberValid() {
        // Tests a valid international South African number format
        assertTrue(login.checkPhoneNumber("+27123456789"));
    }

    @Test
    public void testPhoneNumberInvalid() {
        // Tests an invalid number that lacks the +27 format
        assertFalse(login.checkPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUserSuccess() {
        // Tests that a valid registration returns the exact success message from Login.java
        String expectedMessage = "The two above conditions have been met and the user has been registered successfully.";
        String actualMessage = login.registerUser("ky_1", "P@ssword1!", "John", "Doe", "+27821234567");
        
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginLogicSuccess() {
        // Registers a user first to populate the stored credentials
        login.registerUser("ky_1", "P@ssword1!", "John", "Doe", "+27821234567");
        
        // Tests a successful login attempt with matching credentials
        assertTrue(login.loginUser("ky_1", "P@ssword1!"));
    }

    @Test
    public void testLoginLogicFailure() {
        // Registers a user first to populate the stored credentials
        login.registerUser("ky_1", "P@ssword1!", "John", "Doe", "+27821234567");
        
        // Tests a failed login attempt with an incorrect password
        assertFalse(login.loginUser("ky_1", "wrongPass"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        // Registers a user to set the name and surname variables
        login.registerUser("ky_1", "P@ssword1!", "John", "Doe", "+27821234567");
        
        // Tests the exact string output for a successful login
        String expectedMessage = "Welcome John, Doe it is great to see you again.";
        String actualMessage = login.returnLoginStatus(true);
        
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        // Tests the exact string output for a failed login
        String expectedMessage = "Username or password incorrect, please try again.";
        String actualMessage = login.returnLoginStatus(false);
        
        assertEquals(expectedMessage, actualMessage);
    }
}