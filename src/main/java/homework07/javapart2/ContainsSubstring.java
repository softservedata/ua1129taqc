package homework07.javapart2;

/** Create a method that checks whether a certain substring is contained in
 a given string, and returns the index of its first occurrence.
 */

public class ContainsSubstring {
    public static int findSubstringIndex(String mainString, String substring){
        return mainString.indexOf(substring);
    }

    public static void main(String[] args) {
        String mainString = "Have a nice day";
        String substring = "day";
        int substringIndex = findSubstringIndex(mainString, substring);
        if(substringIndex != -1){
         System.out.print("Substring " + substring + " is contained in a given string at index: " + substringIndex);
        }
        else {
            System.out.print("Substring " + substring + " not found in the given string");
        }


    }
}
