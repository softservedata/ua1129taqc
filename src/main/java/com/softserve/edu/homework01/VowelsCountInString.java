package com.softserve.edu.homework01;

import java.util.Scanner;

public class VowelsCountInString {
    public static void main(String[] args) {

        /*
        Write a program that asks the user to input a string. Then, using a loop, count how many vowels
        (a, e, i, o, u) are in the string. Output the total number of vowels found.
         */

        int vowelsCount = 0;

        System.out.println("Counting vowels in a string...");

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a string: ");

        String str = sc.nextLine();

        str = str.toLowerCase().trim();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i'
                    || currentChar == 'o' || currentChar == 'u') {
                vowelsCount++;
            }
        }

        System.out.println("Number of vowels found: " + vowelsCount);

        sc.close();
    }
}
