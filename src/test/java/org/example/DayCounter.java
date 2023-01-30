package org.example;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class DayCounter {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate januaryFirst = LocalDate.of(now.getYear(), 1, 1);
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(januaryFirst, now);
        long result = (daysBetween + 1) * 2;
        String resultString = String.valueOf(result);
        if(resultString.length() == 2) {
            resultString = "0" + resultString;
        }
        System.out.println("The result is: " + resultString);

        // Read the JSON file
        String filePath = "C:\\Users\\Christianne Cesar\\Documents\\playground\\TechnicalCodeInterview\\Data\\Menu.json";
        JSONObject json = readJsonFromFile(filePath);

        // Check if the key "Admin_Password" exists
        if (json.has("TC")) {
            JSONObject nestedJson = json.getJSONObject("TC");
            if (nestedJson.has("Admin_Password")) {
                // Update the value of "Admin_Password"
                nestedJson.put("Admin_Password", resultString);

                // Write the updated JSON to the file
                try {
                    FileWriter fileWriter = new FileWriter(filePath);
                    fileWriter.write(json.toString(0)); // 0 spaces for indentation
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("The key 'Admin_Password' does not exist in the nested JSON object.");
            }
        } else {
            System.out.println("The key 'nested_object' does not exist in the JSON file.");
        }
    }

    // Method to read JSON from a file
    private static JSONObject readJsonFromFile(String filePath) {
        JSONObject json = null;
        try {
            FileReader fileReader = new FileReader(filePath);
            json = new JSONObject(new JSONTokener(fileReader));
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
