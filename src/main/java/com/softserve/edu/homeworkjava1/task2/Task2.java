package com.softserve.edu.homeworkjava1.task2;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float firstTemperature = scanner.nextFloat();
        float secondTemperature = scanner.nextFloat();
        float thirdTemperature = scanner.nextFloat();
        float fourthTemperature = scanner.nextFloat();
        float fifthTemperature = scanner.nextFloat();

        float averageTemperature = (firstTemperature + secondTemperature + thirdTemperature + fourthTemperature + fifthTemperature) / 5;
        System.out.println("Average temperature is " + averageTemperature);

    }
}
