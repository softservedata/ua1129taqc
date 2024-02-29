package com.softserve.edu.homeworkjava1.task5;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number >= 90 && number <= 100) {
            System.out.println("Your grade is A");
        } else if (number >= 80 && number <= 89) {
            System.out.println("Your grade is B");
        } else if (number >= 70 && number <= 79) {
            System.out.println("Your grade is C");
        } else if (number >= 60 && number <= 69) {
            System.out.println("Your grade is D");
        } else if (number >= 50 && number <= 59) {
            System.out.println("Your grade is F");
        } else {
            System.out.println("Your grade is wrong");
        }
    }
}

