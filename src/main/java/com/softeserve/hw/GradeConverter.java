package com.softeserve.hw;
import java.util.Scanner;

public class GradeConverter {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the numerical score
        System.out.print("Enter the numerical score (out of 100): ");
        int score = scanner.nextInt();

        // Determine the corresponding letter grade based on predefined grade boundaries
        char grade;
        if (score >= 90 && score <= 100) {
            grade = 'A';
        } else if (score >= 80 && score < 90) {
            grade = 'B';
        } else if (score >= 70 && score < 80) {
            grade = 'C';
        } else if (score >= 60 && score < 70) {
            grade = 'D';
        } else if (score >= 0 && score < 60) {
            grade = 'F';
        } else {
            System.out.println("Invalid score. Please enter a score between 0 and 100.");
            return; // Exit the program if the score is invalid
        }

        // Output the corresponding letter grade
        System.out.println("The corresponding letter grade is: " + grade);

        // Close the scanner
        scanner.close();
    }
}
