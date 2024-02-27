/*Task 2
Average Temperature Calculation
Write a program that asks the user for the temperature for five days
 (use the Scanner to enter data)  and calculates the average temperature over those days.
 Use the float variable type to store temperatures and arithmetic operators
 to compute the average value.*/

package Homework_introductionJava;

import java.util.Scanner;

public class Task2_AverageTemper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float totalTemperature = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter the temperature for day " + i + ": ");
            float temperature = scanner.nextFloat();
            totalTemperature += temperature;
        }

        float averageTemperature = totalTemperature / 5;
        System.out.println("Average Temperature over 5 days: " + averageTemperature);
        scanner.close();
    }
}
