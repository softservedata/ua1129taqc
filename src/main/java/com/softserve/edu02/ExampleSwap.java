package com.softserve.edu02;

import java.util.Scanner;

public class ExampleSwap {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("x = ");
            x = sc.nextInt();
            System.out.print("y = ");
            y = sc.nextInt();
        } catch (Exception e) {
            System.out.println("I/O Error.");
            System.exit(1);
        }
        System.out.println("Origin x = " + x + "  y = " + y);
        //
        //int t = x;
        //x = y;
        //y = t;
        //
        x = x + y;
        y = x - y;
        x = x - y;
        //
        System.out.println("Updated x = " + x + "  y = " + y);
    }

}
