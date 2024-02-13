package homework06;

import java.util.Scanner;

/**Task 7: Interest Calculator
 * Write a program that calculates the final amount of a bank deposit
 after a given number of years at a given interest rate. The program
 should ask the user for the initial deposit amount, the annual interest rate,
 and the number of years. Use a loop to calculate compound interest for each year
 and output the result to the console.
 */

public class InterestCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the initial deposit amount,$: ");
        double depositAmount = scanner.nextDouble();
        System.out.println("Enter the annual interest rate,%: ");
        double interestRate = scanner.nextDouble();
        System.out.println("Enter the number of years: ");
        int years = scanner.nextInt();
        double rateDecimal = interestRate / 100;
        scanner.close();

        for (int year = 1; year <= years; year++){
            double finalAmount = depositAmount * Math.pow((1 + rateDecimal), year);
            System.out.println("Year " + year + ", " + "The final amount of the bank deposit is: " + finalAmount);
        }

    }
}
