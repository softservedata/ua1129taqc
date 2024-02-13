package com.softserve.edu.homework01;

import java.math.BigDecimal;
import java.util.Scanner;
import java.math.*;


public class PriceCalculationVAT {

    public static void main(String[] args) {

        /*
        Create a program that asks the user for the price of a product excluding VAT and calculates the final cost
        including VAT (add 20% to the initial price). Display both prices — excluding VAT and including VAT.
        Use the Scanner to enter the initial price.
         */

        BigDecimal vatValue = new BigDecimal(0.20); // VAT value is 20 %

        System.out.println("Calculating the final cost including VAT 20%...");

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the price of a product excluding VAT:");

        BigDecimal initialPrice = sc.nextBigDecimal();

        initialPrice = initialPrice.setScale(2, RoundingMode.HALF_UP);

        BigDecimal finalPrice = initialPrice.add(initialPrice.multiply(vatValue));

        finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Your price excluding VAT:\t\t" + initialPrice);
        System.out.println("Your price including VAT 20%:\t" + finalPrice);

        sc.close();
    }
}
