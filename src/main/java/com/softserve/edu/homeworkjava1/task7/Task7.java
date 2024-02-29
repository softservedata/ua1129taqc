package com.softserve.edu.homeworkjava1.task7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the initial deposit amount");
        double initialDepositAmount = Double.parseDouble(reader.readLine());
        System.out.println("Please enter annual interest rate");
        double annualInterestRate = Double.parseDouble(reader.readLine());;
        System.out.println("Please enter number of years for your deposit");
        int numberOfYears = Integer.parseInt(reader.readLine());

        double currentDepositAmount = initialDepositAmount;
        for (int i = 0; i < numberOfYears; i++) {
            currentDepositAmount = currentDepositAmount * annualInterestRate;
        }
        System.out.println("Total amount: " + currentDepositAmount);
    }
}

