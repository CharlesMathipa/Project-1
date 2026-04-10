import java.util.Scanner;

public class UserInputOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Login login = new Login();

        System.out.println("--- REGISTRATION ---");
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number (e.g., +27123456789): ");
        String phoneNumber = scanner.nextLine();

        String registrationMessage = login.registerUser(username, password, firstName, lastName, phoneNumber);
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

        scanner.close();
    }
}        