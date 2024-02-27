/*Task 3
Counting Vowels in a String
Write a program that asks the user to input a string.
Then, using a loop, count how many vowels (a, e, i, o, u) are in the string.
Output the total number of vowels found.*/

package Homework_introductionJava;

import java.util.Scanner;

public class Task3_Counting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter word: ");
        String inputString = scanner.nextLine().toLowerCase();

        int vowelCount = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                vowelCount++;
            }
        }

        System.out.println("Total number of vowels: " + vowelCount);
        scanner.close();
    }
}
