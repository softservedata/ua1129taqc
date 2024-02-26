package homework07.javapart2;

/** Write a method that takes two strings and returns true if they are equal,
 and false otherwise. Consider the possibility of case-sensitive and
 case-insensitive comparison.
 */

public class EqualStrings {
    public static boolean areEqual (String firstString, String secondString){
        return firstString.equals(secondString);
    }
    public static boolean areEqualIgnoreCase (String firstString, String secondString){
        return firstString.equalsIgnoreCase(secondString);
    }

    public static void main(String[] args) {
        String firstString = "Stop the War";
        String secondString = "stop the war";
        boolean stringsEqual = areEqual(firstString, secondString);
        boolean stringsEqualIgnoreCase = areEqualIgnoreCase(firstString, secondString);
        System.out.println("Case-sensitive comparison: " + stringsEqual);
        System.out.println("Insensitive comparison: " + stringsEqualIgnoreCase);
    }

}
