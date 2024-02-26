package homework07.javapart2;

/** Implement a method that determines whether a string
 contains digits, and returns true or false accordingly.
 */

public class DigitsDeterminer {
    public static boolean containDigits(String inputString){
       return inputString.matches(".*\\d+.*");
    }

    public static void main(String[] args) {
        String inputString = "I am 18 years old";
        boolean result = containDigits(inputString);
        System.out.println("The input string contains digits: " + result);
    }
}
