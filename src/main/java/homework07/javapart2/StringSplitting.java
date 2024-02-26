package homework07.javapart2;

import java.util.Arrays;

/** Create a method that splits a string into an array of
 substrings according to a given delimiter.
 */

public class StringSplitting {
    public static String[] arrayString(String inputString){
        return inputString.split(" ");
    }

    public static void main(String[] args) {
        String inputString = "I want to learn Java";
        String[] resultSplitting = arrayString(inputString);
            System.out.println("An array of substrings: " + Arrays.toString(resultSplitting));

    }
}
