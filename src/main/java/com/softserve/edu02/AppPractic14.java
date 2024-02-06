package com.softserve.edu02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppPractic14 {
    public static void main(String[] args) {
        int x = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("x = ");
            x = sc.nextInt();
        } catch (Exception e) {
            System.out.println("I/O Error.");
            System.exit(1);
        }
        if (x % 2 == 1) {
            System.out.println("odd");
        } else {
            System.out.println("even");
        }
    }
}
