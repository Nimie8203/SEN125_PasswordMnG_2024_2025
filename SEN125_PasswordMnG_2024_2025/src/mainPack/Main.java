package mainPack;

public class Main {
    public static void main(String[] args) {
        Interfaces interfaces = new Interfaces();
        Authenticator authenticator = new Authenticator();
        Generator generator = new Generator();
        Storage storage = new Storage();

        int userInput = -1;

        while (userInput != 0) {
            interfaces.drawMainMenu();
            userInput = interfaces.getUserInput();

            switch (userInput) {
                case 1: // Manager
                    if (authenticator.isFirstTime()) {
                        System.out.print("Set up a new PIN: ");
                        String newPin = interfaces.getUserString();
                        authenticator.setupPin(newPin);
                        System.out.println("PIN setup successfully!");
                    } else {
                        System.out.print("Enter PIN: ");
                        String enteredPin = interfaces.getUserString();
                        if (authenticator.authenticate(enteredPin)) {
                            interfaces.drawManagerMenu(storage);
                        } else {
                            System.out.println("Authentication failed!");
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
                    System.out.println("\nInvalid Input!");
            }
        }
    }
}
