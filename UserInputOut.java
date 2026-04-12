import java.util.Scanner;

public class UserInputOut {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Login login = new Login();
            boolean exitProgram = false;

            // Variables to store data across menu choices
            String name = "";
            String surname = "";
            String username = "";
            String password = "";
            String phoneNumber = "";

            while (!exitProgram) {
                System.out.println("\n=== WELCOME SYSTEM ===");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Please choose an option (1-3): ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("\n--- REGISTRATION ---");
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
                                System.out.println("Username is not correctly formatted; ensure it contains an underscore and is max 5 chars.");
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
                                System.out.println("Password does not meet complexity requirements.");
                            }
                        }

                        boolean checkCellPhoneNumber = false;
                        while (!checkCellPhoneNumber) {
                            System.out.print("Enter phone number (+27...): ");
                            phoneNumber = scanner.nextLine();
                            if (login.checkPhoneNumber(phoneNumber)) {
                                System.out.println("Phone number successfully added.");
                                checkCellPhoneNumber = true;
                            } else {
                                System.out.println("Invalid phone number format.");
                            }
                        }

                        System.out.println(login.registerUser(username, password, name, surname, phoneNumber));
                        break;

                    case "2":
                        System.out.println("\n--- LOGIN ---");
                        System.out.print("Enter your username: ");
                        String loginUserName = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        String loginPassword = scanner.nextLine();

                        boolean isValidLogin = login.loginUser(loginUserName, loginPassword);
                        System.out.println(login.returnLoginStatus(isValidLogin));

                        if (isValidLogin) {
                            System.out.println("Access Granted to System Features.");
                            // You can add a sub-menu here later
                        }
                        break;

                    case "3":
                        System.out.println("Exiting program... Goodbye!");
                        exitProgram = true;
                        break;

                    default:
                        System.out.println("Invalid selection. Please choose 1, 2, or 3.");
                }
            }
        }
    }
}