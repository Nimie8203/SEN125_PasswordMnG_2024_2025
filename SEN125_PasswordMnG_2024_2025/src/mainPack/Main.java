package mainPack;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Interfaces interfaces = new Interfaces();

        int userInput = -1;

        while (userInput != 0) {
            interfaces.drawMainMenu();
            userInput = interfaces.getUserInput();

            switch (userInput) {
                case 1: // Manager
                    interfaces.drawManagerMenu(storage);
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
