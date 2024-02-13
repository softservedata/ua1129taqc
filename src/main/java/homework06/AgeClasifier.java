package homework06;

import java.util.Scanner;

/**Task 6: Simple Age Category Classifier
 The program asks the user to input their age, and based on the age,
 it categorizes them as a child, teenager, adult, or senior. For example,
 0-12 years could be a child, 13-19 a teenager, 20-59 an adult, and 60+ a senior.
 */

public class AgeClasifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.close();

        if (age <= 12 && age > 0){
            System.out.print("You are a child");
        } else if (age <= 19 && age > 12) {
            System.out.print("You are a teenager");
        } else if (age <= 59 && age > 19){
            System.out.print("You are an adult");
        } else if (age > 59){
            System.out.print("Your are a senior");
        } else {
            System.out.print("Unknown");
        }

    }
}
