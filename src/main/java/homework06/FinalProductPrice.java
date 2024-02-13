package homework06;


import java.util.Scanner;

/** Task 1: Calculation of the Final Product Price Including VAT
 * Create a program that asks the user for the price of a product excluding
 VAT and calculates the final cost including VAT (add 20% to the initial price).
 Display both prices — excluding VAT and including VAT.
 Use the Scanner to enter the initial price.
 */

public class FinalProductPrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the price of a product excluding VAT: ");
        double priceWithoutVat = scanner.nextDouble();
        scanner.close();

        double VAT = 0.20;
        double priceWithVat = priceWithoutVat + (priceWithoutVat * VAT);
        System.out.println("Price of a product excluding VAT, $: " + priceWithoutVat);
        System.out.println("Final price of a product including VAT, $: " + priceWithVat);

    }
}