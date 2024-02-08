package com.softserve.edu03;

import java.util.Scanner;

public class AppMultiplicationTable {
    public static void main(String[] args) {
        int number = 0;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Input number = ");
        number = sc1.nextInt();
        sc1.close();
        //
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + number * i);
        }
    }
}
