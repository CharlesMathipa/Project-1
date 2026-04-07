import java.util.Scanner;
public class LoginPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String username, saCellNumber, password;
        boolean loggedIn = false;

        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter cellular number: ");
        saCellNumber = scanner.nextLine();

     /*this is where the user will be asked to enter their password, and 
     the the complexity will be checked*/
 while (!loggedIn) {
           
            boolean isValidComplexity = false;

            do {
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                
               
                isValidComplexity = checkPasswordComplexity(password);
                
                if (isValidComplexity) {
                    System.out.println("Password successfully captured"); 
                } else {
                    System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."); 
                }
                
            } while (!isValidComplexity);

            
            if (username.equals("admin") && password.equals("Password123!")) {
                System.out.println("Login successful! Welcome, " + username + "!");
                loggedIn = true; 
            } else {
                System.out.println("Login failed! Invalid username or password. Please try again.");
                System.out.println("--------------------------------------------------");
            }
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
