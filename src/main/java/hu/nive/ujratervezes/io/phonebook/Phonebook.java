package hu.nive.ujratervezes.io.phonebook;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {

    void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException("One of the arguments is 'null'!");
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(output);
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                fileWriter.write(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ioe) {
                System.out.println("At least we tried...");
            }
        }
    }
}