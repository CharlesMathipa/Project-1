import java.util.regex.Pattern;

//these stored variables will be used to store the user information for later use in the login process
public class Login {
    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

public boolean checkPasswordComplexity(String password) {
  if (password == null || password.length() < 8) return false;

    boolean hasUpper = false;
    boolean hasDigit = false;
    boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
            // Check for non-alphanumeric character
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }
        return hasUpper && hasDigit && hasSpecial;
    }
// the regex pattern for the phone number is: ^\+27\d{9}$ to ensure that the phone number starts with +27 followed by exactly 9 digits.
public boolean checkPhoneNumber(String phoneNumber) {
    
    String regex = "^\\+27\\d{9}$";
    return Pattern.matches(regex, phoneNumber);
}

public String registerUser(String username, String password, String firstName, String lastName, String phoneNumber) {
    if (!checkUserName(username)) {
        return "Username is not correctly formatted...";
    }
    
    if (!checkPasswordComplexity(password)) {
        return "Password is not correctly formatted...";
    }

   
    if (!checkPhoneNumber(phoneNumber)) {
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    this.storedUsername = username;
    this.storedPassword = password;
    this.firstName = firstName;
    this.lastName = lastName;
    
    return "The two above conditions have been met and the user has been registered successfully.";
}

public String returnLoginStatus(boolean isLoginSuccessful) {
    if (isLoginSuccessful) {
        // Return a welcome message with the user's first and last name
        return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
}
}