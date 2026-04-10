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
    }
}        