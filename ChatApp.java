/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp2;

/**
 *
 * @author Fayama
 */
import java.util.Scanner;

public class ChatApp3 {

  public static void main(String[] args) {
 Scanner input = new Scanner(System.in);
      

// Username
System.out.println("Enter username: ");
String username = input.nextLine();
System.out.println(validateUsername(username));

// Password
System.out.println("Enter password: ");
String password = input.nextLine();
System.out.println(validatePassword(password));

// Cell phone number
System.out.println("Enter cell phone number: ");
String phone = input.nextLine();
System.out.println(validatePhone(phone));

input.close();
}

// Username Validation
public static String validateUsername(String username) {
if (username.contains("_") && username.length() <= 5) {
return "Username successfully captured.";
} else {
return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
}
}

// Password Validation
public static String validatePassword(String password) {
boolean hasUpper = false;
boolean hasNumber = false;
boolean hasSpecial = false;

for (char c : password.toCharArray()) {
if (Character.isUpperCase(c)) {
hasUpper = true;
} else if (Character.isDigit(c)) {
hasNumber = true;
} else if (!Character.isLetterOrDigit(c)) {
hasSpecial = true;
}
}

if (password.length() >= 8 && hasUpper && hasNumber && hasSpecial) {
return "Password successfully captured.";
} else {
return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
}
}
// Phone Number Validation (Regex)
public static String validatePhone(String phone) {
String regex = "^\\+27\\d{9}$";
//+ international code
// d{9} number must contain 9 digits
//$ end of string

if (phone.matches("^\\+27\\d{9}$")) {
return "Cell phone number successfully added.";
} else {
return "Cell phone number incorrectly formatted or does not contain international code.";
}
}

public class UserRegistration {
   //Login with the same username and password
    String savedUsername = "**_**";
    String savedPassword = "*****";
    String firstName = "******";
    String lastName = "********";
    
public boolean checkLogin(String username, String password) {
        return savedUsername.equals(username)&& savedPassword.equals(password);
    }
    public String getMessage(boolean isValid) {
        if (isValid==true) {
            return ("Welcome" + firstName + "," + lastName + "it is great to see you again.");
        } else {
           return ("Username or password incorrect, please try again");
        }
    }
}

public class Login{
    String savedUsername;
    String savedPassword;
    
    //Check Username
    public boolean checkUserName(String username) {
        
        //Must contain "_" and be 5 characters or less
        if (username.contains("_")&& username.length()<=5) {
            return true;
        } else {
            return false;
        }
    }
    //Check Password
    public boolean checkPasswordComplexity(String password) {
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        //Check each character
        for (int i=0;i<password.length(); i++) {
            char ch = password.charAt(i);
            
            if(Character.isUpperCase(ch)) {
                hasCapital = true;
            }else if
         (Character.isDigit(ch)) {
                hasNumber = true;
            }else if(!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }          
        }
        //Check all conditions
        if (password.length()>= 8 && hasCapital && hasNumber && hasSpecial){
            return true;
        } else {
            return false;
        }
    }
    public boolean checkCellPhoneNumber(String phone) {
        if(phone.startsWith("+27") && phone.length() ==12){
            return true;
        } else {
            return false;
        }       
    }
    public String registerUser(String username, String password) {
        if(!checkUserName(username)) {
            return "Username is not correct.";
        }
        if(!checkPasswordComplexity(password)) {
            return "Password is not strong enough";
        }
        savedUsername = username;
        savedPassword = password; 
        
return "User registered successfully.";
    }
    public boolean loginUser(String username, String password) {
        
        if(username.equals(savedUsername) && password.equals(savedPassword)){
            return true;
        }else{
            return false;
        }
        }          
    public String returnLoginStatus(boolean status) {
        
        if(status==true) {
            return "Login succesful";
        }else{
            return "Login failed";    
        }
    }
}
}
public class Test {

Login login = new Login();

// Username Tests
public void testUsernameCorrect() {
assertEquals(true, login.checkUserName("kyl_1"));
}

public void testUsernameIncorrect() {
assertEquals(false, login.checkUserName("kyle!!!!!!!"));
}

// Password Tests
public void testPasswordCorrect() {
assertEquals(true, login.checkPassword("Ch&&sec@ke99!"));
}

public void testPasswordIncorrect() {
assertEquals(false, login.checkPassword("password"));
}

// Cell Number Tests
public void testCellCorrect() {
assertEquals(true, login.checkCellPhoneNumber("+27838968976"));
}

public void testCellIncorrect() {
assertEquals(false, login.checkCellPhoneNumber("08966553"));
}

// Login Test
public void testLoginSuccess() {
assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
}

public void testLoginFail() {
assertFalse(login.loginUser("wrong", "password"));
}
}




   

    


         



