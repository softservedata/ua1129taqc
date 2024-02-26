package homework07.javapart2;

/** Write a method that removes all leading and trailing spaces from a string.
 */

public class RemoveSpaces {
    public static String deleteSpaces(String inputString){
        return inputString.trim();
    }

    public static void main(String[] args) {
        String inputString = "                Good job               ";
        String stringWithoutSpaces = deleteSpaces(inputString);
        System.out.println("Input string: " + inputString);
        System.out.println("Modified string: " + stringWithoutSpaces);
    }
}
