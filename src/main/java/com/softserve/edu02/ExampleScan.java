package com.softserve.edu02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExampleScan {
    public static void main(String[] args) {
        int x = 0;
        String s = "0";
        System.out.print("Input number: ");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("x = ");
            s = sc.nextLine();
            x = Integer.parseInt(s);
            //
            System.out.print("Input second line: ");
            s = sc.nextLine();
            //
            /*
            System.out.print("x = ");
            x = sc.nextInt();
            System.out.print("Input second line: ");
            s = sc.nextLine();
            s = sc.nextLine();
            */
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("I/O Error.");
        }
        System.out.println("Number is " + (x + 1));
        System.out.println("Line is " + s);

    }
}
