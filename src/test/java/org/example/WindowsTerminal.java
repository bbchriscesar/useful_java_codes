package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WindowsTerminal {
    public static void main(String[] args) {
        try {
            // Run "cmd.exe /c dir" in the command prompt
            Process process = Runtime.getRuntime().exec("cmd.exe /c adb devices");

            // Get the input stream and read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
