package com.softserve.edu05set;

public class AppContent {
    public static void main(String[] args) {
        int[] num1 = {1, 3, 1, 2, 4, 3};
        int[] num2 = {3, 3, 2, 1, 3, 4, 1, 2};
        //
        boolean isEqual = true;
        for (int i = 0; i < num1.length; i++) {
            isEqual = false;
            for (int j = 0; j < num2.length; j++) {
                if (num1[i] == num2[j]) {
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                break;
            }
        }
        for (int i = 0; i < num2.length; i++) {
            isEqual = false;
            for (int j = 0; j < num1.length; j++) {
                if (num2[i] == num1[j]) {
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                break;
            }
        }
        //
        System.out.printf("isEqual = " + isEqual);

    }
}
