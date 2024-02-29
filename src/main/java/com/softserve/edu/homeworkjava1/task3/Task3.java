package com.softserve.edu.homeworkjava1.task3;

import java.util.Scanner;
import java.util.Set;

public class Task3 {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toLowerCase().toCharArray();

        int count = 0;
        for (char letter : chars) {
            if (VOWELS.contains(letter)) {
                count++;
            }
        }
        System.out.println("Total number of vowels - " + count);
    }
}
