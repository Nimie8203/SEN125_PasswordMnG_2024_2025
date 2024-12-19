package mainPack;

import java.util.Scanner;

public class Interfaces {
    private Scanner scanner = new Scanner(System.in);

    public void drawMainMenu() {
        System.out.println("===== PASSWORD MANAGER MENU =====");
        System.out.println("1. Manage Passwords");
        System.out.println("2. Generate Password");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }

    public void drawGenerator(Generator generator, Storage storage) {
        System.out.println("\n=== PASSWORD GENERATOR ===");
        String generatedPassword = generator.generatePassword();
        System.out.println("Generated Password: " + generatedPassword);

        System.out.print("Do you want to save this password? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            storage.saveEntry(username, generatedPassword, "Unknown");
            System.out.println("Password saved successfully!");
        }
    }

    public void drawManagerMenu(Storage storage) {
        System.out.println("\n=== MANAGER MENU ===");
        System.out.println("1. Add Password");
        System.out.println("2. View Stored Passwords");
        System.out.println("0. Return to Main Menu");
        System.out.print("Choose an option: ");

        int option = getUserInput();

        switch (option) {
            case 1:
                System.out.print("Enter Username: ");
                String username = scanner.next();
                System.out.print("Enter Password: ");
                String password = scanner.next();
                storage.saveEntry(username, password, "Unknown");
                System.out.println("Password saved successfully!");
                break;
            case 2:
                System.out.println("Stored Passwords:");
                for (String entry : storage.getAllEntries()) {
                    System.out.println(entry);
                }
                break;
            case 0:
                System.out.println("Returning to Main Menu...");
                break;
            default:
                System.out.println("Invalid Option.");
        }
    }

    public int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void exitPrompt() {
        System.out.println("Goodbye!");
        scanner.close();
        System.exit(0);
    }
}
