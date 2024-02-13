package homework06;

import java.util.Scanner;

/**Task 2: Average Temperature Calculation
 * Write a program that asks the user for the temperature for
 five days (use the Scanner to enter data)  and calculates the
 average temperature over those days. Use the float variable type to
 store temperatures and arithmetic operators to compute the average value.
 */

public class AverageTemperature {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sumTemperature = 0;
        for (int day = 1; day <= 5; day++){
            System.out.println("Day" + day + ": ");
            float temperature = scanner.nextFloat();
            sumTemperature += temperature;
        }
        scanner.close();

        float averageTemperature = sumTemperature / 5;
        System.out.print("The average temperature over five days is,C: " + averageTemperature);
    }

    }

