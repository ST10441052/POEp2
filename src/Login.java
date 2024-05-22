import java.util.Scanner;

import javax.swing.JOptionPane;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Registration process
        System.out.println("Register your account");

            // area for user to enter ther usernames
        String username;
        do {
            System.out.println("Enter your username (must contain an underscore and not exceed five characters):");
            username = scanner.nextLine();
            if (!Registration.isUsernameValid(username)) {
                System.out.println("Username is not valid. It must contain an underscore and not exceed five characters.");
            }
        } while (!Registration.isUsernameValid(username));
            // area for users to enter their passwords
        String password;
        do {
            System.out.println("Enter your password (must contain at least 8 characters, a capital letter, a number, and a special character):");
            password = scanner.nextLine();
            if (!Registration.isPasswordValid(password)) {
                System.out.println("Password is not correctly formatted. It must contain at least 8 characters, a capital letter, a number, and a special character.");
            }
        } while (!Registration.isPasswordValid(password));

        System.out.println("Registration successful!");

        // Login process
        System.out.println("Please login");

        String loginUsername;
        String loginPassword;
        boolean loginSuccessful = false;

        do {
            System.out.println("Enter your username:");
            loginUsername = scanner.nextLine();

            System.out.println("Enter your password:");
            loginPassword = scanner.nextLine();

            if (username.equals(loginUsername) && password.equals(loginPassword)) {
                loginSuccessful = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } while (!loginSuccessful);

        // Start the EasyKanbanApp
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanApp");
        EasyKanbanApp kanbanApp = new EasyKanbanApp();
        kanbanApp.run();

        scanner.close();
    }
}


  
   
    
   