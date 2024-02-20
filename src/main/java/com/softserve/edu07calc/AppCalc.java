package com.softserve.edu07calc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppCalc {

    public static void main(String[] args) {
        /*
        //int a, b;
        int a = 0;
        int b = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("a = ");
            a = sc.nextInt();
            System.out.print("b = ");
            b = sc.nextInt();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("I/O Error.");
        }
        System.out.println("a + b = " + (a + b));
        System.out.println("a / b = " + (a / b));
        */
        //
        int a = 0;
        int b = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("a = ");
            a = sc.nextInt();
            System.out.print("b = ");
            b = sc.nextInt();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("I/O Error.");
        }
        //
        Calc calc = new Calc();
        System.out.println("a + b = " + calc.add(a, b));
        System.out.println("a / b = " + calc.div(a, b));
    }
}
