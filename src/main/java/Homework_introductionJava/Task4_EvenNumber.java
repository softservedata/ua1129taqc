/*Task 4

Even or Odd Number Checker

Write a program that asks the user to enter a number.
The program then determines whether the number is even or odd using a control
 statement and prints the result/*/

package Homework_introductionJava;
import java.util.Scanner;

public class Task4_EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userNumber = scanner.nextInt();
        checkEvenOdd(userNumber);
        scanner.close();
    }

    private static void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }
    }
}
