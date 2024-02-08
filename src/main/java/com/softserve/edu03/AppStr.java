package com.softserve.edu03;

public class AppStr {
    public static void main(String[] args) {
        /*
        String s = "   \t\t    abc   def  \n   ";
        s = s.trim();
        System.out.print(s);
        */
        /*
        String a0 = "Java"; // equals new String("Java");
        String a1 = "Java"; // set reference
        String a2 = new String("Java"); // create new object
        //
        System.out.println("(a0 == a1) =  " + (a0 == a1)); // true
        System.out.println("(a0 == a2) =  " + (a0 == a2)); // false
        //
        System.out.println("a0.equals(a1) =  " + a0.equals(a1)); // true
        System.out.println("a0.equals(a2) =  " + a0.equals(a2)); // true
        //
        System.out.println("a0.compareTo(a1) =  " + a0.compareTo(a1)); // 0
        System.out.println("a0.compareTo(a2) =  " + a0.compareTo(a2)); // 0
        System.out.println("a0.compareToIgnoreCase(a2) =  " + a0.compareToIgnoreCase(a2)); // 0
        //
        System.out.println("a0.hashCode() =  " + a0.hashCode());
        System.out.println("a1.hashCode() =  " + a1.hashCode());
        System.out.println("a2.hashCode() =  " + a2.hashCode());
		*/
        /*
        String str = "Welcome";
        System.out.println("str.contains(\"come\") = " + str.contains("come"));
        */
        /*
        String str = "abracadabra abba";
        System.out.println("Original = " + str);
        //str = str.replace("a", "-");
        //str = str.replaceAll("a\\b", "-"); // a-zA-Z_0-9 Word char
        //str = str.replaceAll("\\Ba\\B", "-");
        str = str.replace("ab", "-");
        System.out.println("Updated = " + str);
        */
        /*
        String str = "abracadabra abba";
        System.out.println("Original = " + str);
        //str = str.substring(3);
        //str = str.substring(3, 8);
        str = str.toUpperCase();
        System.out.println("Updated = " + str);
        */
        /*
        String str = "abr;acadabra abba";
        String[] arr = str.split(";| ");
        for (String current : arr) {
            System.out.println("current = " + current);
        }
        */
        int num = 123;
        String str = String.valueOf(num);
        str = str.concat("1");
        str = str + "1";
        System.out.println("Updated = " + str);
        num = Integer.valueOf(str);
        //num = Integer.parseInt(str);
        num = num + 1;
        System.out.println("num = " + num);
    }
}
