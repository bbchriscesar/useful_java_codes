package org.example;

import java.io.*;

public class ReadActivationCode {
    public static void main(String[] args) throws IOException {
        String currentDir = System.getProperty("user.dir");
        File newCurrentDir = new File(currentDir + "\\src\\test\\resources\\");
        System.out.println(newCurrentDir);

        File file = new File(newCurrentDir + "\\" + "file.txt");
        File tempFile = new File(newCurrentDir + "\\" +"file_temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        // skip the first line
        reader.readLine();

        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            writer.write(currentLine + System.lineSeparator());
        }

        reader.close();
        writer.close();

        // delete the original file
        if (!file.delete()) {
            System.out.println("Failed to delete the original file");
        }

        // rename the temp file to the original file
        if (!tempFile.renameTo(file)) {
            System.out.println("Failed to rename the temp file");
        }
    }
}
