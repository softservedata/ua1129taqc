package com.softeserve.hw;
import java.util.Scanner;



public class VATCalculation {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the price excluding VAT
        System.out.print("Enter the price of the product excluding VAT: ");
        double priceExcludingVAT = scanner.nextDouble();

        // Calculate the final cost including VAT (20% VAT)
        double VATRate = 0.20;
        double VATAmount = priceExcludingVAT * VATRate;
        double totalPriceIncludingVAT = priceExcludingVAT + VATAmount;

        // Display both prices
        System.out.println("Price excluding VAT: $" + priceExcludingVAT);
        System.out.println("Price including VAT (20%): $" + totalPriceIncludingVAT);

        // Close the scanner
        scanner.close();
    }
}