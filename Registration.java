
import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Register register = new Register();
        Scanner scanner = new Scanner(System.in);

        String username, saCellNumber, password;

        System.out.print("Enter username: ");
        username = scanner.nextLine();
        register.setUsername(username);
        System.out.print("Enter cell number: ");
        saCellNumber = scanner.nextLine();
        register.setSaCellNumber(saCellNumber);

        do{System.out.print("Enter password: ");
        password = scanner.nextLine();
        if (!checkPasswordComplexity(password)){
            System.out.println("Password is incorrect");}
        }while(!checkPasswordComplexity(password));
        register.setPassword(password);

        

        printRegisterData(register);

        scanner.close();

    }
    private static void printRegisterData(Register register) {
        System.out.println(register.getUsername());
        System.out.println(register.getSaCellNumber());
        System.out.println(register.getPassword());
    }
    //the password complexity rules of the checkpasswordcomplexity() method
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

class Register{
    private String username;
    private String saCellNumber; 
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSaCellNumber() {
        return saCellNumber;
    }
    public void setSaCellNumber(String saCellNumber) {
        this.saCellNumber = saCellNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}