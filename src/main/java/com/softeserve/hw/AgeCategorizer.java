package com.softeserve.hw;
import java.util.Scanner;

public class AgeCategorizer {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their age
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        // Determine the category based on age
        String category;
        if (age >= 0 && age <= 12) {
            category = "child";
        } else if (age >= 13 && age <= 19) {
            category = "teenager";
        } else if (age >= 20 && age <= 59) {
            category = "adult";
        } else if (age >= 60) {
            category = "senior";
        } else {
            System.out.println("Invalid age. Please enter a valid age.");
            return; // Exit the program if the age is invalid
        }

        // Output the category
        System.out.println("You are categorized as a " + category + ".");

        // Close the scanner
        scanner.close();
    }
}