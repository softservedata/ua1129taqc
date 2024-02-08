package com.softserve.edu03;

import java.util.Scanner;

public class AppReverseString {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string = ");
        String str = sc.nextLine();
        System.out.println("Origin string = " + str);
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        System.out.println("Reverse string = " + reverse);
        */
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string = ");
        String str = sc.nextLine();
        System.out.println("Origin string = " + str);
        StringBuilder sb = new StringBuilder(str);
        String reverse = sb.reverse().toString();
        System.out.println("Reverse string = " + reverse);
    }
}
