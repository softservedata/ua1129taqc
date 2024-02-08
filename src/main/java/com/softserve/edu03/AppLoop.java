package com.softserve.edu03;

import java.util.Scanner;

public class AppLoop {

    public static void main(String[] args) {
        /*
        int number = 0;
        while (number <= 5) {
            System.out.println("Number = " + number);
            number++;
        }
        */
        /*
        int i = 10;
        do {
            System.out.println("i = " + i++);
        } while (i < 5);
        */
        //
        //int[] numbers = new int[]{5, 6, 8, 3, 5, 7, 9};
        //int[] numbers = {5, 6, 8, 3, 5, 7, 9};
        //
//        int[] numbers = new int[7];
//        numbers[0] = 5;
//        numbers[1] = 6;
//        numbers[2] = 8;
//        numbers[3] = 3;
//        numbers[4] = 5;
//        numbers[5] = 7;
//        numbers[6] = 9;
        //
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.print("n = ");
        n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Input numbers[" + i + "] = ");
            int num = sc.nextInt();
            if (num < 0){
                //break;
                continue;
            }
            numbers[i] = num;
        }
        sc.close();
        //
        System.out.println("Array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        //
        for (int num : numbers) {
            System.out.println("element = " + num);
        }
        //
        System.out.println("done");
    }
}
