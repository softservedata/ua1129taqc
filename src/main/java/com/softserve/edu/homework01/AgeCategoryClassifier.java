package com.softserve.edu.homework01;

import java.util.Scanner;

public class AgeCategoryClassifier {
    public static void main(String[] args) {

        /*
        The program asks the user to input their age, and based on the age, it categorizes them as a
        child, teenager, adult, or senior. For example, 0-12 years could be a child, 13-19 a teenager,
        20-59 an adult, and 60+ a senior.
         */

        int age;
        String ageCategory = "";

        System.out.println("Categorizing the age of a person...");

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Please enter a numerical age from 0 to 125:");

            while (!sc.hasNextInt()) {
                System.out.println("That's not a valid value! Enter a valid one:");
                sc.next();
            }
            age = sc.nextInt();
        } while (age < 0 || age > 125);

        if (age >= 0 && age <= 12) {
            ageCategory = "child";
        } else if (age >= 13 && age <= 19) {
            ageCategory = "teenager";
        } else if (age >= 20 && age <= 59) {
            ageCategory = "adult";
        } else {
            ageCategory = "senior";
        }

        System.out.printf("The value of %d years old corresponds to the category \"%s\".", age, ageCategory);

        sc.close();
    }
}
