package org.example;


import java.io.IOException;

public class ClassTester {
    public static void main(String[] args) throws IOException {
        String deletedLine = RemoveFirstLine.removeFirstLine();

        System.out.println("Activation code consumed: " + deletedLine);
    }
}
