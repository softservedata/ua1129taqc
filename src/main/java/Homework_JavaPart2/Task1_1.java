/*1. Write a method that takes two strings and returns true if they are equal,
and false otherwise. Consider the possibility of
case-sensitive and case-insensitive comparison.*/

package Homework_JavaPart2;

    public class Task1_1  {

        public static void main(String[] args) {
            String str1 = "Hello";
            String str2 = "hello";

            // Case-sensitive comparison
            boolean caseSensitiveResult = areStringsEqual(str1, str2, true);
            System.out.println("Case-sensitive comparison: " + caseSensitiveResult);

            // Case-insensitive comparison
            boolean caseInsensitiveResult = areStringsEqual(str1, str2, false);
            System.out.println("Case-insensitive comparison: " + caseInsensitiveResult);
        }

        public static boolean areStringsEqual(String str1, String str2, boolean caseSensitive) {
            if (caseSensitive) {
                // Case-sensitive comparison
                return str1.equals(str2);
            } else {
                // Case-insensitive comparison
                return str1.equalsIgnoreCase(str2);
            }
        }
    }
