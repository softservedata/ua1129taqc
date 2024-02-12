package com.softeserve.hw;

import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to input a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Convert the input string to lowercase to simplify counting
        inputString = inputString.toLowerCase();

        // Initialize variables to count vowels
        int vowelCount = 0;

        // Loop through each character in the input string and count vowels
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }

        // Output the total number of vowels found
        System.out.println("Total number of vowels in the string: " + vowelCount);

        // Close the scanner
        scanner.close();
    }
}