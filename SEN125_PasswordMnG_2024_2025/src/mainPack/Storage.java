package mainPack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final String FILE_NAME = "passwords.txt";
    private List<String> entries;

    public Storage() {
        this.entries = new ArrayList<>();
        loadEntries();
    }

    public void saveEntry(String username, String password, String location) {
        String entry = username + "," + password + "," + location;
        entries.add(entry);
        saveAllEntries();
    }

    public void updateEntry(int index, String username, String password, String location) {
        if (index >= 0 && index < entries.size()) {
            String entry = username + "," + password + "," + location;
            entries.set(index, entry);
            saveAllEntries();
        }
    }

    public void deleteEntry(int index) {
        if (index >= 0 && index < entries.size()) {
            entries.remove(index);
            saveAllEntries();
        }
    }

    public List<String> getAllEntries() {
        return new ArrayList<>(entries);
    }

    private void loadEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entries.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading entries: " + e.getMessage());
        }
    }

    private void saveAllEntries() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String entry : entries) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving entries: " + e.getMessage());
        }
    }
}
