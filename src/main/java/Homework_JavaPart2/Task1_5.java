/*2. Implement a method that takes a string and two indices,
 and returns the substring that is contained between those indices.*/

package Homework_JavaPart2;

public class Task1_5 {

    public static void main(String[] args) {
        String str1 = "Hello world!";
        String str2 = "Year 2023";

        System.out.println("String 1 contains digits: " + containsDigits(str1));
        System.out.println("String 2 contains digits: " + containsDigits(str2));
    }

    public static boolean containsDigits(String str) {
        for (char character : str.toCharArray()) {
            if (Character.isDigit(character)) {
                return true;
            }
        }
        return false;
    }
}
