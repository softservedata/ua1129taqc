package com.softserve.edu.homework02;

public class StringOperations {

    /*
    Task 1.1 Write a method that takes two strings and returns true if they are equal, and false otherwise.
    Consider the possibility of case-sensitive and case-insensitive comparison.
    */

    public static boolean compareTwoStringsCaseSensitive(String str1, String str2) {
        return str1.equals(str2);

    }

    public static boolean compareTwoStringsCaseInsensitive(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);

    }

    /*
    Task 1.2 Implement a method that takes a string and two indices, and returns the substring
    that is contained between those indices.
    */

    public static String createSubstringBetweenTwoIndices(String str, int index1, int index2) {
        return str.substring(index1, index2);
    }

    /*
    Task 1.5 Implement a method that determines whether a string contains digits,
    and returns true or false accordingly.
     */

    public static boolean checkDigitInString(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    /*
    Task 1.6 Write a method that removes all leading and trailing spaces from a string.
     */

    public static String removeAllSpaces(String str) {
        return str.trim();
    }



    public static void main(String[] args) {


        // Task 1.1
        System.out.println("----------------------------------------------------------------");

        String string1 = "Java";
        String string2 = "Java";
        String string3 = "JAva";

        System.out.println("Comparing " + string1 + " and "
                + string2 + " (case-sensitive): "
                + compareTwoStringsCaseSensitive(string1, string2)); // true

        System.out.println("Comparing " + string1 + " and "
                + string3 + " (case-sensitive): "
                + compareTwoStringsCaseSensitive(string1, string3)); //false

        System.out.println("Comparing " + string1 + " and "
                + string3 + " (case-insensitive): "
                + compareTwoStringsCaseInsensitive(string1, string3)); //true

        // Task 1.2

        System.out.println("----------------------------------------------------------------");

        String string4 = "Welcome to Java!";
        int index1 = 11;
        int index2 = 15;

        System.out.println("Creating a substring from string + \"" + string4
                + "\": " + createSubstringBetweenTwoIndices(string4, index1, index2)); //Java

        // Task 1.5

        System.out.println("----------------------------------------------------------------");

        String string5 = "Welcome to Java 2024!";

        System.out.println("Searching for a digit in a string \""
                + string5 + "\": " + checkDigitInString(string5)); //true

        System.out.println("Searching for a digit in a string \""
                + string4 + "\": " + checkDigitInString(string4)); // false

        // Task 1.6

        System.out.println("----------------------------------------------------------------");

        String string6 = "     Welcome to Java Test Automation Course!             ";

        System.out.println("Original and trimmed strings:");
        System.out.println(string6);
        System.out.println(removeAllSpaces(string6));

    }
}
