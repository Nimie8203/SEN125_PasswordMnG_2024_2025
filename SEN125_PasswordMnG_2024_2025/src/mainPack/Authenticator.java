package mainPack;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Authenticator {
    private static final String PIN_FILE = "pin.txt";
    private String hashedPin;

    public Authenticator() {
        hashedPin = readStoredPin();
    }

    private String readStoredPin() {
        try {
            if (new File(PIN_FILE).exists()) {
                return Files.readString(Paths.get(PIN_FILE)).trim();
            }
        } catch (Exception e) {
            System.out.println("Error reading PIN file: " + e.getMessage());
        }
        return null;
    }

    public void setupPin(String pin) {
        try {
            hashedPin = Encryptor.cipher(pin);
            Files.writeString(Paths.get(PIN_FILE), hashedPin);
        } catch (Exception e) {
            System.out.println("Error setting up PIN: " + e.getMessage());
        }
    }

    public boolean authenticate(String pin) {
        try {
            return Encryptor.compare(hashedPin, pin);
        } catch (Exception e) {
            System.out.println("Authentication error: " + e.getMessage());
            return false;
        }
    }

    public boolean isFirstTime() {
        return hashedPin == null;
    }
}
