package org.example;

public class StringReverser {
    public static void main(String[] args) {
        String str = "hello";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
    }

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}

/*      This code defines a reverseString method that takes a string as input and returns the
        reversed version of that string. The method uses a StringBuilder to build the reversed
        string. It starts at the end of the input string and works its way towards the beginning, appending
        each character to the StringBuilder along the way. Finally, it converts the StringBuilder to a
        String and returns it.

        The main method is included as an example of how to use the reverseString method.
        When you run this code, it will print out "The reversed string is: olleh".                       */