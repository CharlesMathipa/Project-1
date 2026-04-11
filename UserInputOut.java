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


            boolean checkUserName = false;
            while (!checkUserName) {
                System.out.print("Enter a username: ");
                username = scanner.nextLine();
                if (login.checkUserName(username)) {
                    System.out.println("Username successfully captured."); 
                    checkUserName = true;
                } else {
                    System.out.println("Username is not correctly formatted; please ensure that the username contains an underscore and is no more than five characters long.");
                }
            }

            boolean checkPasswordComplexity = false;
            while (!checkPasswordComplexity) {
                System.out.print("Enter a password: ");
                password = scanner.nextLine();
                if (login.checkPasswordComplexity(password)) {
                    System.out.println("Password successfully captured.");
                    checkPasswordComplexity = true;
                } else {
                    System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
                }
            }
            
            boolean checkCellPhoneNumber = false;
            while (!checkCellPhoneNumber) {
                System.out.print("Enter your phone number with the international South African code included(e.g., +27123456789): ");
                phoneNumber = scanner.nextLine();
                if (login.checkPhoneNumber(phoneNumber)) {
                    System.out.println("Phone number successfully added.");
                    checkCellPhoneNumber = true;
                } else {
                    System.out.println("Phone number is incorrectly formatted or does not contain the international code.");
                }
            }

            String registrationMessage = login.registerUser(username, password, name, surname, phoneNumber);
            System.out.println(registrationMessage);
            
            if (registrationMessage.equals("The two above conditions have been met and the user has been registered successfully.")) {

                System.out.println("\n--- LOGIN ---");
                while (!checkUserName) {
                System.out.print("Enter your username to login: ");
                String loginUserName = scanner.nextLine();
                if (login.checkUserName(username)) {
                    System.out.println("Username successfully captured."); 
                    checkUserName = true;
                } else {
                    System.out.println("Username is not correctly formatted; please ensure that the username contains an underscore and is no more than five characters long.");
                }
            }

                System.out.print("Enter your password to login: ");
                String loginPassword = scanner.nextLine();

                //this block checks if login is valid
                boolean isValidLogin = login.loginUser(loginUserName, loginPassword);

                //this section gets the final status message and print it
                String loginStatusMessage = login.returnLoginStatus(isValidLogin);
                System.out.println(loginStatusMessage);

                isLoggedIn = isValidLogin;
            }
        }
    }
