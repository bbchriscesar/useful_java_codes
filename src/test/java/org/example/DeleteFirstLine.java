package org.example;

import java.io.*;
import java.util.Scanner;

public class DeleteFirstLine {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Christianne Cesar\\Documents\\playground\\TechnicalCodeInterview\\src\\test\\resources\\8-DLPARAM.TXT";
        String tempFilePath = "C:\\Users\\Christianne Cesar\\Documents\\playground\\TechnicalCodeInterview\\src\\test\\resources\\temp.TXT";
        try (Scanner sc = new Scanner(new File(filePath));
             PrintWriter pw = new PrintWriter(new File(tempFilePath))) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                pw.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        new File(filePath).delete();
        new File(tempFilePath).renameTo(new File(filePath));
    }
}
