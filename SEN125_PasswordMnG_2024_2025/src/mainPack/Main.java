package mainPack;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Interfaces interfaces = new Interfaces();
        Generator generator = new Generator();
        Authenticator authenticator = new Authenticator();

        int userInput = -1;

        while (userInput != 0) {
            interfaces.drawMainMenu();
            userInput = interfaces.getUserInput();

            switch (userInput) {
                case 1: // Manager
                    if (authenticator.isFirstTime()) {
                        System.out.println("No PIN set up yet.");
                        System.out.print("Set up a new PIN: ");
                        String newPin = interfaces.getUserString();
                        authenticator.setupPin(newPin);
                        System.out.println("PIN set successfully!");
                    } else {
                        System.out.print("Enter PIN: ");
                        String enteredPin = interfaces.getUserString();
                        if (authenticator.authenticate(enteredPin)) {
                            interfaces.drawManagerMenu(storage);
                        } else {
                            System.out.println("Authentication failed. Returning to Main Menu.");
                        }
                    }
                    break;

                case 2: // Password Generator
                    interfaces.drawGenerator(generator, storage);
                    break;

                case 0: // Exit
                    interfaces.exitPrompt();
                    break;

                default:
                    System.out.println("Invalid Input! Try again.");
            }
        }
    }
}
