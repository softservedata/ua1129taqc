package com.softserve.edu08junit;

public class MyArray {

    public static int[] createArray() {
        return new int[]{1, 2, 3, 4, 5};
    }

    public static boolean arrayContainsNumber(int[] arr, int num) {
        for (int current : arr) {
            if (current == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println("Original:");
        for (int num : arr) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }
}
