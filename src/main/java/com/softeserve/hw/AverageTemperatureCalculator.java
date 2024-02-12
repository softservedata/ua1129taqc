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
}
