package com.softserve.edu.homework01;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {

        /*
        Write a program that takes a numerical score (like a test score out of 100)
        and outputs the corresponding letter grade (A, B, C, D, F).
        Define the grade boundaries yourself (for example, 90-100 is an A, 80-89 is a B, etc.).
         */

        int score;

        System.out.println("Converting a numerical score to a letter grade...");

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Please enter a numerical score from 0 to 100:");

            while (!sc.hasNextInt()) {
                System.out.println("That's not a valid score! Enter a valid one:");
                sc.next();
            }
            score = sc.nextInt();
        } while (score < 0 || score > 100);

        String result = switch (score / 10) {
            case 9, 10  -> "A"; // 90...100 is A
            case 8 -> "B"; // 80...89 is B
            case 7 -> "C"; // 70...79 is C
            case 6 -> "D"; // 60...69 is D
            default -> "F"; // 0...59 is F
        };

        System.out.printf("Your numerical score %d corresponds to the grade %s.", score, result);

        sc.close();
    }
}
