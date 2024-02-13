package com.softserve.edu.homework01;

import java.util.Scanner;

public class AverTempCalculation {
    public static void main(String[] args) {

        /*
        Write a program that asks the user for the temperature for five days (use the Scanner to enter data)
        and calculates the average temperature over those days. Use the float variable type to store temperatures
        and arithmetic operators to compute the average value.
         */

        int numberOfDays = 5;
        float temperatureSum = 0f;

        System.out.println("Calculating the average temperature...");

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= numberOfDays; i++) {
            System.out.println("Please enter the temperature value for day " + i + ":");
            temperatureSum += sc.nextFloat();
        }

        System.out.println("The average temperature over " + numberOfDays + " days is: "
                + temperatureSum / numberOfDays);

        sc.close();
    }
}
