package mainPack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_NAME = "passwords.txt";

    public void saveEntry(String username, String password, String location) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(username + "," + password + "," + location + "\n");
        } catch (IOException e) {
            System.out.println("Error saving entry: " + e.getMessage());
        }
    }

    public void updateEntry(int index, String username, String password, String location) {
        List<String> entries = getAllEntries();
        if (index >= 0 && index < entries.size()) {
            entries.set(index, username + "," + password + "," + location);
            saveAllEntries(entries);
        }
    }

    public void deleteEntry(int index) {
        List<String> entries = getAllEntries();
        if (index >= 0 && index < entries.size()) {
            entries.remove(index);
            saveAllEntries(entries);
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

    private void saveAllEntries(List<String> entries) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (String entry : entries) {
                writer.write(entry + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving entries: " + e.getMessage());
        }
    }
}
