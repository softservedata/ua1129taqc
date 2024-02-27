/*7. Create a method that splits a string into an array of substrings according
to a given delimiter.*/

package Homework_JavaPart2;

public class Task1_7 {

    public static void main(String[] args) {
        String inputString = "apple,orange,banana,grape";
        String delimiter = ",";

        String[] resultArray = splitString(inputString, delimiter);

        System.out.println("Original String: " + inputString);
        System.out.println("Array of substrings after splitting by '" + delimiter + "':");
        for (String substring : resultArray) {
            System.out.println(substring);
        }
    }

    public static String[] splitString(String str, String delimiter) {
        // Use the split method to split the string into an array
        return str.split(delimiter);
    }
}
