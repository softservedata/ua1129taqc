package com.softserve.edu.homeworkjava1.task6;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if (age >= 0 && age <= 12) {
            System.out.println("You are a child");
        } else if (age >= 13 && age <= 19) {
            System.out.println("You are a teenager");
        } else if (age >= 20 && age <= 59) {
            System.out.println("You are an adult");
        } else if (age >= 60 && age <= 110) {
            System.out.println("You are a senior");
        } else {
            System.out.println("You have entered an invalid age");
        }
    }
}

