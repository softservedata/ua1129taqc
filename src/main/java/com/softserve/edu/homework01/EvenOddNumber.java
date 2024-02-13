package com.softserve.edu.homework01;

import java.util.Scanner;

public class EvenOddNumber {


    public static void main(String[] args) {

        /*
        Write a program that asks the user to enter a number. The program then determines whether the number
        is even or odd using a control statement and prints the result.
         */

        long number;

        System.out.println("Checking if the number is even or odd...");

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a whole number from " + Long.MIN_VALUE + " to " + Long.MAX_VALUE + ":");

        while (!sc.hasNextLong()) {
            System.out.println("That's not a valid number! Please enter a valid one:");
            sc.next();
        }

        number = sc.nextLong();

        if (number % 2 == 0) {
            System.out.printf("Number %d is even", number);
        } else {
            System.out.printf("Number %d is odd", number);
        }

        sc.close();
    }
}
