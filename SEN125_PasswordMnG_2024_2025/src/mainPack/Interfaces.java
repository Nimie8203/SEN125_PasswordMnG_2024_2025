package mainPack;

import java.util.Scanner;

public class Interfaces {
    private Scanner scanner = new Scanner(System.in);

    public void drawMainMenu() {
        System.out.println("=====================================");
        System.out.println(">>       PASSWORD MANAGER MENU      <<");
        System.out.println("=====================================");
        System.out.println("->  1. Manager");
        System.out.println("->  2. Generator");
        System.out.println("->  0. Exit");
        System.out.println("=====================================");
        System.out.print("Select an option: ");
    }

    public void exitPrompt() {
        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
        System.exit(0);
    }

    public void drawManagerMenu(Storage storage) {
        int option = -1;
        while (option != 0) {
            System.out.println("\n=========== Manager Menu ===========");

            // Display stored entries
            System.out.println("========== Stored Passwords ==========");
            if (storage.getAllEntries().isEmpty()) {
                System.out.println("No entries found.");
            } else {
                for (int i = 0; i < storage.getAllEntries().size(); i++) {
                    System.out.println((i + 1) + ". " + storage.getAllEntries().get(i));
                }
            }
            System.out.println("=======================================");

            // Display operations
            System.out.println("Operations:");
            System.out.println("1. Add Entry");
            System.out.println("2. Edit Entry");
            System.out.println("3. Delete Entry");
            System.out.println("0. Back to Main Menu");
            System.out.print("Select an operation: ");

            option = getUserInput();

            switch (option) {
                case 1: // Add entry
                    drawAddEntry(storage);
                    break;
                case 2: // Edit entry
                    drawEditEntry(storage);
                    break;
                case 3: // Delete entry
                    drawDeleteEntry(storage);
                    break;
                case 0: // Exit
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid Option. Try again!");
            }
        }
    }

    private void drawAddEntry(Storage storage) {
        System.out.print("Enter Username: ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        System.out.print("Enter Location: ");
        String location = scanner.next();
        storage.saveEntry(username, password, location);
        System.out.println("Entry added successfully!");
    }

    private void drawEditEntry(Storage storage) {
        if (storage.getAllEntries().isEmpty()) {
            System.out.println("No entries available to edit.");
            return;
        }

        System.out.print("Select the entry number to edit: ");
        int index = getUserInput() - 1;

        if (index >= 0 && index < storage.getAllEntries().size()) {
            System.out.print("Enter new Username: ");
            String newUsername = scanner.next();
            System.out.print("Enter new Password: ");
            String newPassword = scanner.next();
            System.out.print("Enter new Location: ");
            String newLocation = scanner.next();
            storage.updateEntry(index, newUsername, newPassword, newLocation);
            System.out.println("Entry updated successfully!");
        } else {
            System.out.println("Invalid entry number!");
        }
    }

    private void drawDeleteEntry(Storage storage) {
        if (storage.getAllEntries().isEmpty()) {
            System.out.println("No entries available to delete.");
            return;
        }

        System.out.print("Select the entry number to delete: ");
        int index = getUserInput() - 1;

        if (index >= 0 && index < storage.getAllEntries().size()) {
            storage.deleteEntry(index);
            System.out.println("Entry deleted successfully!");
        } else {
            System.out.println("Invalid entry number!");
        }
    }

    public void drawGenerator(Generator generator, Storage storage) {
        System.out.println("\n========== Password Generator ==========");
        System.out.print("Enter the desired password length: ");
        int length = getUserInput();

        if (length < 6) {
            System.out.println("Password length must be at least 6 characters.");
            return;
        }

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("y");

        String password = generator.generatePassword(length, includeUppercase, includeDigits, includeSpecial);
        System.out.println("Generated Password: " + password);

        System.out.print("Save this password? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            System.out.print("Enter Username: ");
            String username = scanner.next();
            System.out.print("Enter Location: ");
            String location = scanner.next();
            storage.saveEntry(username, password, location);
            System.out.println("Password saved successfully!");
        }
    }

    public int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getUserString() {
        return scanner.next();
    }
}
