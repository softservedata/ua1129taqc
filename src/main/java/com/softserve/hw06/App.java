package com.softserve.hw06;

import java.util.Scanner;

/**
 * Homework 06 (https://softserve.academy/mod/assign/view.php?id=18486)
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("price = ");
        double price = sc.nextDouble();
        double price2 = price + price*0.2;
        System.out.print("price2 = " + price2);
    }
}
