package org.example;

import java.io.*;

public class InsertText {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Christianne Cesar\\Documents\\playground\\TechnicalCodeInterview\\src\\test\\resources\\8-DLPARAM.TXT");
        String textToInsert = "ActivationCode=\"000000000\"";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            StringBuilder oldText = new StringBuilder();
            while((line = reader.readLine()) != null) {
                oldText.append(line).append(System.lineSeparator());
            }
            reader.close();

            String newText = textToInsert + System.lineSeparator() + oldText;

            FileWriter writer = new FileWriter(file);
            writer.write(newText);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
