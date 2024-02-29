package com.softserve.edu.homeworkjava1.task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("Number is even " + number);
        } else {
            System.out.println("Number is odd " + number);
        }
    }
}
