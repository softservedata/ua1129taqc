/*2. Implement a method that takes a string and two indices,
and returns the substring that is contained between those indices.*/

package Homework_JavaPart2;

public class Task1_2 {

    public static void main(String[] args) {
        String inputString = "Hello, World!";
        int startIndex = 7;
        int endIndex = 12;

        String result = extractSubstring(inputString, startIndex, endIndex);

        System.out.println("Original String: " + inputString);
        System.out.println("Substring between indices " + startIndex + " and " + endIndex + ": " + result);
    }

    public static String extractSubstring(String str, int startIndex, int endIndex) {
        // Ensure that the indices are within the bounds of the string
        if (startIndex >= 0 && endIndex < str.length() && startIndex <= endIndex) {
            // Use the substring method to extract the desired substring
            return str.substring(startIndex, endIndex + 1);
        } else {
            // Handle invalid indices
            return "Invalid indices";
        }
    }
}
