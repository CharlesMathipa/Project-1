import java.util.Scanner;
public class LoginPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String username, saCellNumber, password;

        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter cellular number: ");
        saCellNumber = scanner.nextLine();

     /*this is where the user will be asked to enter their password, and 
     the the complexity will be checked*/
        do {
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            
            
            if (!checkPasswordComplexity(password)) {
                System.out.println("Password must be at least 8 characters and include uppercase, lowercase, digit, and special character. Please try again.");
            }
            
        } while (!checkPasswordComplexity(password));

        
        if (username.equals("admin") && password.equals("Password123!")) {
            System.out.println("Login successful! Welcome, " + username + "!");
        } else {
            System.out.println("Login failed! Invalid username or password.");
        }

        scanner.close(); 

    }

    private static boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }//end of the checkpasswordcomplexity() method
}
