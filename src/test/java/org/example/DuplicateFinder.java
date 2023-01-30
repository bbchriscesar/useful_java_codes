package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class DuplicateFinder {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Christianne Cesar\\Documents\\playground\\TechnicalCodeInterview\\src\\test\\resources\\sunmi.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        // Keep track of keys we've already seen
        java.util.Set<Object> keys = new java.util.HashSet<Object>();

        java.util.Enumeration<Object> propertyKeys = properties.keys();
        while (propertyKeys.hasMoreElements()) {
            String key = (String) propertyKeys.nextElement();
            if (keys.contains(key)) {
                // Add "#" to the duplicated key
                String newKey = key + "#";
                // Get the value of the duplicated key
                String value = properties.getProperty(key);
                // Remove the duplicated key-value pair
                properties.remove(key);
                // Add the new key-value pair with the "#" added
                properties.setProperty(newKey, value);
            } else {
                keys.add(key);
            }
        }
        // Save the updated properties to the file
        properties.store(new FileWriter(file), "");
    }
}
