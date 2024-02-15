package com.softserve.edu05list;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AppMonth {
    public static void main(String[] args) {
        /*
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < monthDays.length; i++) {
            System.out.print(monthDays[i] + "  ");
        }
        //
        System.out.print("\nArrays: " + Arrays.toString(monthDays));
        */
        /*
        int[][] twoD= new int[4][];
        twoD[0]= new int[5];
        twoD[1]= new int[2];
        twoD[2]= new int[3];
        twoD[3]= new int[7];
        //
        twoD[0][1] = 5;
        */
        /*
        System.out.println();
        int[][] irregular = {{1}, {2, 3, 4}, {5}, {6, 7}};
        for (int i = 0; i < irregular.length; i++) {
            for (int j = 0; j < irregular[i].length; j++) {
                System.out.print(irregular[i][j] + "  ");
            }
            System.out.println();
        }
        */
        int[] numbers = { 2, -5, 8, -4, 7 };
        System.out.println("Original numbers: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
        int index = Arrays.binarySearch(numbers, 7);
        System.out.println("index: " + index);
    }
}
