package com.softeserve.hw;
import java.util.Scanner;

public class AverageTemperatureCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Initialize variables
        float totalTemperature = 0;

        // Prompt the user to enter the temperature for each day and calculate the total temperature
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter the temperature for day " + i + ": ");
            float temperature = scanner.nextFloat();
            totalTemperature += temperature;
        }

        // Calculate the average temperature
        float averageTemperature = totalTemperature / 5;

        // Display the average temperature
        System.out.println("Average temperature over five days: " + averageTemperature + " degrees");

        // Close the scanner
        scanner.close();
    }

    public static class Calculation {
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

    public static class VowelCounter {
        public static void main(String[] args) {
            // Create a Scanner object to read input from the user
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to input a string
            System.out.print("Enter a string: ");
            String inputString = scanner.nextLine();

            // Convert the input string to lowercase to simplify counting
            inputString = inputString.toLowerCase();

            // Initialize variables to count vowels
            int vowelCount = 0;

            // Loop through each character in the input string and count vowels
            for (int i = 0; i < inputString.length(); i++) {
                char ch = inputString.charAt(i);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCount++;
                }
            }

            // Output the total number of vowels found
            System.out.println("Total number of vowels in the string: " + vowelCount);

            // Close the scanner
            scanner.close();
        }
    }
}