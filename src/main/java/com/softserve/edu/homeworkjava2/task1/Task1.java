package com.softserve.edu.homeworkjava2.task1;

import java.util.Arrays;
import java.util.Set;

public class Task1 {

    private static final Set<String> DIGITS = Set.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    public static void main(String[] args) {
        // test part 1
        System.out.println(stringsEqual("Vasya", "vasya"));
        System.out.println(stringsEqual("Vasya", "vasya"));
        System.out.println(stringsEqual("Vasya", "Vasya1"));

        // test part 2
        System.out.println(substring("I love pizza", 2, 6));

        // test part 3
        System.out.println(indexOfFirstOccurrence("I love pizza", "love"));
        System.out.println(indexOfFirstOccurrence("I love pizza", "Dog"));

        // test part 4
        System.out.println(replacesAllOccurrences("I love pizza", "pizza", "cakes"));

        // test part 5
        System.out.println(containsDigits("I have 3 banana and 5 apples"));
        System.out.println(containsDigits("I have bags"));

        // test part 6
        System.out.println(removesSpaces("         I love pizza          "));

        // test part 7
        System.out.println(Arrays.toString(splitBy("I love pizza,banana,apples", ",")));
    }

    // part 1
    public static boolean stringsEqual(String first, String second) {
        return first.equalsIgnoreCase(second);
    }

    // part 2
    public static String substring(String str, int begin, int end) {
        return str.substring(begin, end);
    }

    // part 3
    public static int indexOfFirstOccurrence(String baseString, String substring) {
        if (baseString.contains(substring)) {
            return baseString.indexOf(substring);
        } else {
            return -1;
        }
    }

    // part 4
    public static String replacesAllOccurrences(String baseString, String partToReplace, String replacement) {
        return baseString.replaceAll(partToReplace, replacement);
    }

    // part 5
    public static boolean containsDigits(String str) {
    //  return str.matches(".*\\d.*");   // solution with regular expression
        for (String digit: DIGITS) {
            if (str.contains(digit)) {
                return true;
            }
        }
        return false;
    }

    // part 6
    public static String removesSpaces(String str) {
        return str.trim();
    }

    // part 7
    public static String[] splitBy(String str, String delimiter) {
        return str.split(delimiter);
    }
}


