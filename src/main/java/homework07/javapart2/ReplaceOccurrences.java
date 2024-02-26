package homework07.javapart2;

/**Write a method that replaces all occurrences of one
 substring with another in a given string.
 */

public class ReplaceOccurrences {
    public static String replace(String inputText, String oldString, String newString){
        return inputText.replace(oldString,newString);
    }

    public static void main(String[] args) {
        String inputText = "You are very beautiful";
        String oldString = "beautiful";
        String newString = "awesome";
        String replaceSubstring = replace(inputText, oldString, newString);
        System.out.println("Original string: " + inputText);
        System.out.println("Modified string: " + replaceSubstring);
    }
}
