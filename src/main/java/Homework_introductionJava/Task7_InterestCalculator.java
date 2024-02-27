/*Task 7

Interest Calculator

Write a program that calculates the final amount of a bank deposit after
a given number of years at a given interest rate.
The program should ask the user for the initial deposit amount,
the annual interest rate, and the number of years.
Use a loop to calculate compound interest for each year and output the result to the console.

Some information for solution

The formula for calculating the final amount of a bank deposit using compound interest is given by:

A=P×(1+r)t

where:

� is the amount of money accumulated after n years, including interest.
P is the principal amount (the initial amount of money).

r is the annual interest rate (decimal).
t is the time the money is invested for, in years.*/

package Homework_introductionJava;
import java.util.Scanner;

public class Task7_InterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть початкову суму вкладу: ");
        double principal = scanner.nextDouble();

        System.out.print("Введіть річну процентну ставку (у десятковому вигляді): ");
        double interestRate = scanner.nextDouble();

        System.out.print("Введіть кількість років: ");
        int years = scanner.nextInt();


        double compoundInterest = calculateCompoundInterest(principal, interestRate, years);
        System.out.println("Кінцева сума після " + years + " років становить: " + compoundInterest);


        scanner.close();
    }


    private static double calculateCompoundInterest(double principal, double interestRate, int years) {
        return principal * Math.pow((1 + interestRate), years);
    }
}
