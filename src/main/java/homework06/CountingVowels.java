package homework06;

import java.util.Scanner;

/**Task 3: Counting Vowels in a String
 * Write a program that asks the user to input a string.
 Then, using a loop,count how many vowels (a, e, i, o, u) are in the string.
 Output the total number of vowels found.
 */

public class CountingVowels {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        scanner.close();

        inputString = inputString.toLowerCase();
        int totalNumberVowels = 0;

        for (int i = 0; i < inputString.length(); i++){
            char inputChar = inputString.charAt(i);
            if (inputChar == 'a' || inputChar == 'o'|| inputChar == 'e' || inputChar == 'u' || inputChar == 'i')
                totalNumberVowels++;
        }
        System.out.print("The total number of vowels is: " + totalNumberVowels);

    }
}
