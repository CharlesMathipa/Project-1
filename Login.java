import java.util.regex.Pattern;
import java.util.regex.Matcher;

// the regex pattern for the phone number is: ^\+27\d{9}$ to ensure that the phone number starts with +27 followed by exactly 9 digits.
public boolean checkPhoneNumber(String phoneNumber) {
    
    String regex = "^\\+27\\d{9}$";
    return Pattern.matches(regex, phoneNumber);
}