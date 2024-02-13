package com.softserve.edu;
/* First task
import java.util.Scanner;

public class HomeworkJavaBasics {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("How much");
        String price = scan.nextLine();

        double discountedPrice = Double.parseDouble(price) * 0.2;
        System.out.println("20% of " + price + " is: " + discountedPrice );

        double finalPrice = discountedPrice + Double.parseDouble(price);
        System.out.println("Final price: " + finalPrice);
    }
}
*/

/* Second task
import java.util.Scanner;
public class HomeworkJavaBasics{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float totalTemperature = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter temperature for day " + i + ": ");
            float temperature = scanner.nextFloat();
            totalTemperature += temperature;
        }

        float averageTemperature = totalTemperature / 5;

        System.out.println("Average temperature over five days: " + averageTemperature);
    }
}
*/

/*  task 3
import java.util.Scanner;

public class HomeworkJavaBasics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Need your word");
        String input = scan.nextLine().toLowerCase();

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        System.out.println(("Total number of vowels found: " + count));
    }
}
*/
/*  task 4
import java.util.Scanner;

public class HomeworkJavaBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Add number");
        String input = scan.nextLine();

        int i = Integer.parseInt(input);

        if (i % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }

        scan.close();
    }
}
 */

/*  task 5
import java.util.Scanner;

public class HomeworkJavaBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Wait your number");
        String input = scan.nextLine();

        int i = Integer.parseInt(input);

        if (i >= 90 && i <= 100) {
            System.out.println("A grade");
        } else if (i >= 70 && i < 90) {
            System.out.println("B grade");
        } else if (i >= 50 && i < 70) {
            System.out.println("C grade");
        } else {
            System.out.println("D grade");
        }

        scan.close();
    }
}

 */
/*  task 6
import java.util.Scanner;

public class HomeworkJavaBasics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write your age");
        String input = scan.nextLine();

        int i = Integer.parseInt(input);

        if (i >= 60 && i <= 100) {
            System.out.println("Senior");
        } else if (i >= 20 && i < 60) {
            System.out.println("Adult");
        } else if (i >= 15 && i < 20) {
            System.out.println("Teenager");
        } else {
            System.out.println("Child");
        }

        scan.close();
    }
}

 */
import java.util.Scanner;

public class HomeworkJavaBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for initial deposit amount
        System.out.print("Enter initial deposit amount: ");
        double principal = scanner.nextDouble(); //p

        // Ask for annual interest rate
        System.out.print("Enter annual interest rate (as a percentage): ");
        double annualInterestRate = scanner.nextDouble();//

        // Convert annual interest rate to monthly interest rate
        double monthlyInterestRate = annualInterestRate / 100 / 12;//r

        // Ask for the number of years
        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();//t

        // Calculate the final amount after the specified number of years
        double finalAmount = principal * Math.pow(1 + monthlyInterestRate, years * 12);//A=P×(1+r)t


        // Display the final amount
        System.out.println("After " + years + " years, the final amount will be: $" + finalAmount);

        scanner.close();
    }
}

