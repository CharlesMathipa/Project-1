import java.util.Scanner;

public class UserInputOut {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Login login = new Login();

            String name;
            String surname;
            String username;
            String password;
            String phoneNumber;
            
            System.out.println("--- REGISTRATION ---");
            System.out.print("Enter your Name: ");
            name = scanner.nextLine();
            
            System.out.print("Enter your Surname: ");
            surname = scanner.nextLine();
            
            System.out.print("Enter a username: ");
            username = scanner.nextLine();
            
            System.out.print("Enter a password: ");
            password = scanner.nextLine();
            
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
}        