/* Task 1
Calculation of the Final Product Price Including VAT
Create a program that asks the user for the price of
a product excluding VAT and calculates the final cost
including VAT (add 20% to the initial price).
Display both prices &mdash; excluding VAT and including VAT.
Use the Scanner to enter the initial price. */

package Homework_introductionJava;

import java.util.Scanner;

public class Task1_Calculation_VAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial price (excluding VAT): ");
        double initialPrice = scanner.nextDouble();
        double vatRate = 0.20;
        double finalPrice = initialPrice * (1 + vatRate);
        System.out.println("Price excluding VAT: UAH" + initialPrice);
        System.out.println("Price including VAT: UAH" + finalPrice);
        scanner.close();
    }
}
