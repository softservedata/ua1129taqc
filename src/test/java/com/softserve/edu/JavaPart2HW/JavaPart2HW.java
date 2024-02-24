package com.softserve.edu.JavaPart2HW;
/*Task1(1)
public class JavaPart2HW {
    public static void main(String[] args) {
        String first = "This is my Homework";
        String second = "This IS My Homework";

        if (first.equalsIgnoreCase(second)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
*/

/*Task 1(2)
public class JavaPart2HW {
    public static void main(String[] args) {
    String Str = ("This is Task two");
    System.out.println("This substring" + " " + (Str.substring(8,10)));
}
}

 */
/* Task 1(4)
public class JavaPart2HW {
    public static void main(String[] args) {
    String old = "Hi this is my Homework";
        String replaceString=old.replace('i','I');//replaces all occurrences of 'a' to 'e'
        System.out.println(replaceString);


    }
}
 //
Task1 (3)
public class JavaPart2HW {
    public static void main(String[] args) {
        String str = "Hello World!";
        int index = str.indexOf("World");
        System.out.println(index);
    }
}
//
 */
/*
Task1 (5)
public class JavaPart2HW {
    public static void main(String[] args) {
        String str = "123R6";
        boolean allDigits = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                allDigits = false;
                break;
            }
        }
        if (allDigits) {
            System.out.println("true");
        }
            else{
                System.out.println("False");
            }
        }
    }

/*

 */
/* Task 7
public class JavaPart2HW {
    public static void main(String[] args) {
        String str = " HELLO!   my name   is  Veronika!   ";
        String trimmedStr = str.replaceAll("\\s+", " ").trim();;
        System.out.println(trimmedStr);
    }
}
 */

public class JavaPart2HW {
    public static void main(String[] args) {
        String str = "apple,banana,orange";
        String[] arrOfStr = str.split(",", 5);
        for (String a : arrOfStr)
            System.out.println(a);
    }
}