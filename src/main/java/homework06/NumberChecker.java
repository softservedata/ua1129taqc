package homework06;

import java.util.Scanner;

/**Task 4: Even or Odd Number Checker
 * Write a program that asks the user to enter a number.
 The program then determines whether the number is even or
 odd using a control statement and prints the result.
 */

public class NumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        String determineNumber = (number % 2 == 0) ? "The number is even" : "This number is odd";
        System.out.print(determineNumber);
    }
}
