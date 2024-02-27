/* Task 5

Grade Calculator
Write a program that takes a numerical score
(like a test score out of 100) and outputs the corresponding letter grade (A, B, C, D, F).
Define the grade boundaries yourself (for example, 90-100 is an A, 80-89 is a B, etc.).*/


package Homework_introductionJava;
import java.util.Scanner;

public class Task5_Grade_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the numerical score (out of 100): ");
        int numericalScore = scanner.nextInt();

        String letterGrade = convertToLetterGrade(numericalScore);

        System.out.println("The corresponding letter grade is: " + letterGrade);

        scanner.close();
    }

    private static String convertToLetterGrade(int score) {
        if (score >= 90 && score <= 100) {
            return "A";
        } else if (score >= 80 && score < 90) {
            return "B";
        } else if (score >= 70 && score < 80) {
            return "C";
        } else if (score >= 60 && score < 70) {
            return "D";
        } else if (score >= 0 && score < 60) {
            return "F";
        } else {
            return "Invalid score. Please enter a score between 0 and 100.";
        }
    }
}
