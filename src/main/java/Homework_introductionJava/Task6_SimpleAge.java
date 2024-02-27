/*Task 6

Simple Age Category Classifier
The program asks the user to input their age,
and based on the age, it categorizes them as a child,
 teenager, adult, or senior. For example,
 0-12 years could be a child, 13-19 a teenager, 20-59 an adult, and 60+ a senior.*/


package Homework_introductionJava;
import java.util.Scanner;

public class Task6_SimpleAge {
    public static void main(String[] args) {

        System.out.print("Enter your age: ");

        try (Scanner scanner = new Scanner(System.in)) {
            int age = scanner.nextInt();


            String ageCategory = classifyAge(age);


            System.out.println("You are a " + ageCategory);
        } catch (Exception e) {
            System.out.println("Please enter a valid age as a numeric value.");
        }
    }


    private static String classifyAge(int age) {
        if (age >= 0 && age <= 12) {
            return "child";
        } else if (age >= 13 && age <= 19) {
            return "teenager";
        } else if (age >= 20 && age <= 59) {
            return "adult";
        } else if (age >= 60) {
            return "senior";
        } else {
            return "Invalid age";
        }
    }
}
