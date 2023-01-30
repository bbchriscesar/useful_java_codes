package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GetSerialNo {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("cmd /c adb get-serialno");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String serialNo = in.readLine();
            System.out.println(serialNo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
