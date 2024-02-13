package com.softserve.edu.homework01;

import java.math.BigDecimal;
import java.util.Scanner;
import java.math.*;

public class InterestCalculator {
    public static void main(String[] args) {

        /*
        Write a program that calculates the final amount of a bank deposit after a given number of years
        at a given interest rate. The program should ask the user for the initial deposit amount,
        the annual interest rate, and the number of years. Use a loop to calculate compound interest
        for each year and output the result to the console.
        */

        BigDecimal initialDeposit;
        BigDecimal annualInterestRate;
        int numberOfYears;
        BigDecimal finalAmount;

        System.out.println("Calculating compound interest...");

        Scanner sc = new Scanner(System.in);

        //No input validation
        System.out.println("Please enter the initial deposit amount:");
        initialDeposit = sc.nextBigDecimal();

        //No input validation
        System.out.println("Please enter the annual percentage interest rate:");
        annualInterestRate = sc.nextBigDecimal().divide(BigDecimal.valueOf(100));

        //No input validation
        System.out.println("Please enter the time the money is invested for, in years:");
        numberOfYears = sc.nextInt();

        finalAmount = initialDeposit;

        for (int i = 1; i <= numberOfYears; i++) {
            finalAmount = finalAmount.add(finalAmount.multiply(annualInterestRate));
        }

        finalAmount = finalAmount.setScale(2, RoundingMode.HALF_UP);

        System.out.println("The final amount of a bank deposit: " + finalAmount);

        sc.close();
    }
}
