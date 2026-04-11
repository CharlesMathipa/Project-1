import java.util.Scanner;
import java.util.regex.Pattern;


public class UserInputOut {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Login login = new Login();

            String name = "";
            String surname = "";
            String username = "";
            String password = "";
            String phoneNumber = "";
            
            System.out.println("--- REGISTRATION ---");
            System.out.print("Enter your Name: ");
            name = scanner.nextLine();
            
            System.out.print("Enter your Surname: ");
            surname = scanner.nextLine();


            boolean validUsername = false;
            while (!validUsername) {
                System.out.print("Enter a username: ");
                username = scanner.nextLine();
                if (login.checkUserName(username)) {
                    validUsername = true;
                } else {
                    System.out.println("Username is not correctly formatted. It must contain an underscore and be no more than 5 characters long. Please try again.");
                }
            }

            boolean validPassword = false;
            while (!validPassword) {
                System.out.print("Enter a password: ");
                password = scanner.nextLine();
                if (login.checkPasswordComplexity(password)) {
                    validPassword = true;
                } else {
                    System.out.println("Password is not correctly formatted. It must be at least 8 characters long, contain an uppercase letter, a digit, and a special character. Please try again.");
                }
            }
            
            System.out.print("Enter your phone number with the international South African code included(e.g., +27123456789): ");
            phoneNumber = scanner.nextLine();
            
            String registrationMessage = login.registerUser(username, password, name, surname, phoneNumber);
            System.out.println(registrationMessage);
            
            if (registrationMessage.equals("The two above conditions have been met and the user has been registered successfully.")) {
                
                System.out.println("\n--- LOGIN ---");
                System.out.print("Enter your username to login: ");
                String loginUsername = scanner.nextLine();
                
                System.out.print("Enter your password to login: ");
                String loginPassword = scanner.nextLine();
                
                //this block checks if login is valid
                boolean isValidLogin = login.loginUser(loginUsername, loginPassword);
                
                //this section gets the final status message and print it
                String loginStatusMessage = login.returnLoginStatus(isValidLogin);
                System.out.println(loginStatusMessage);
            }
        }
    }

    //these stored variables will be used to store the user information for later use in the login process
public static class Login {
    private String storedUsername;
    private String storedPassword;
    private String name;
    private String surname;
    private String phoneNumber;

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
        return hasUpper && hasDigit && hasSpecial && password.length() >= 8;
    }

// the regex pattern for the phone number is: ^\+27\d{9}$ to ensure that the phone number starts with +27 followed by exactly 9 digits.
public boolean checkPhoneNumber(String phoneNumber) {
    
    String regex = "^\\+27\\d{9}$";
    return Pattern.matches(regex, phoneNumber);
}

public String registerUser(String username, String password, String name, String surname, String phoneNumber) {
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
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
    return "The two above conditions have been met and the user has been registered successfully.";
}

public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(this.storedUsername) && enteredPassword.equals(this.storedPassword);
    }

public String returnLoginStatus(boolean isLoginSuccessful) {
    if (isLoginSuccessful) {
        // Return a welcome message with the user's first and last name
        return "Welcome " + name + ", " + surname + " it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
}
}
}        