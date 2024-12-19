package mainPack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_NAME = "passwords.txt";

    public void saveEntry(String username, String password, String location) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(username + "," + password + "\n");
        } catch (IOException e) {
            System.out.println("Error saving entry: " + e.getMessage());
        }
    }

    public List<String> getAllEntries() {
        List<String> entries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading entries: " + e.getMessage());
        }
        return entries;
    }
}
