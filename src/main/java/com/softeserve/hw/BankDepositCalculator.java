package com.softeserve.hw;
import java.util.Scanner;

public class BankDepositCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter initial deposit amount, annual interest rate, and number of years
        System.out.print("Enter the initial deposit amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in percentage): ");
        double annualInterestRate = scanner.nextDouble() / 100; // Convert percentage to decimal

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Calculate the final amount using compound interest formula for each year
        double finalAmount = principal;
        for (int i = 0; i < years; i++) {
            finalAmount *= (1 + annualInterestRate);
        }

        // Output the final amount
        System.out.println("Final amount after " + years + " years: " + finalAmount);

        // Close the scanner
        scanner.close();
    }
}
