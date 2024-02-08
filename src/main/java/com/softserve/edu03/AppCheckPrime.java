package com.softserve.edu03;

import java.util.Scanner;

public class AppCheckPrime {
    public static void main(String[] args) {
        int number = 0;
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Input number = ");
        number = sc1.nextInt();
        sc1.close();
        //
        boolean isPrime = true;
        int max = (int) (Math.sqrt(number)) + 1;
        for (int i = 2; i < max; i++) {
            if (number % i == 0) {
                isPrime = false;
                System.out.println("i = " + i);
                break;
            }
        }
        System.out.println("isPrime = " + isPrime);
        System.out.println(isPrime ? "Prime" : "NOT Prime");
    }
}
