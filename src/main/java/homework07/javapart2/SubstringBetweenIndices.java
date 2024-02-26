package homework07.javapart2;

/** Implement a method that takes a string and two indices,
 and returns the substring that is contained between those indices.
 */

public class SubstringBetweenIndices {
    public static String containsSubstring (String str) {
        return str.substring(2,6);
    }

    public static void main(String[] args) {
        String str = "circumstances";
        System.out.print("Substring that is contained between indices: " + containsSubstring(str));
    }
}
