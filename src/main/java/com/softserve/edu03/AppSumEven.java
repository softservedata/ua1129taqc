package com.softserve.edu03;

public class AppSumEven {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 10; i = i + 2) {
            sum = sum + i;
        }
        System.out.println("sum = " + sum);
    }
}
