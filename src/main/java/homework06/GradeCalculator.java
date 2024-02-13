package homework06;

import java.util.Scanner;

/**Task 5: Grade Calculator
 * Write a program that takes a numerical score (like a test score out of 100)
 and outputs the corresponding letter grade (A, B, C, D, F).
 Define the grade boundaries yourself (for example, 90-100 is an A, 80-89 is a B, etc.).
 */

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your score: ");
        int score = scanner.nextInt();
        scanner.close();
        char result;

        if (score <= 100 && score >= 90) {
            result = 'A';
        } else if (score < 90 && score >= 80) {
            result = 'B';
        } else if (score < 80 && score >= 70) {
            result = 'C';
        } else if (score < 70 && score >=60) {
            result = 'D';
        } else if (score < 60 && score > 30) {
            result = 'F';
        } else {
            System.out.print("You failed the exam");
            return;
        }
        System.out.print("Your grade is: " + result);
    }
}
