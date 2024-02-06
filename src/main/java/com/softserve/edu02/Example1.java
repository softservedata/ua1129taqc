package com.softserve.edu02;

public class Example1 {

    /**
     * Super <b>Method</b>
     *
     * @param args Arguments
     */
    public static void main(String[] args) {
        /* This is a sample class which is used to demonstrate
           the use of multi-line comments. This comment does not
           appear in the java documentation
        */
        /*
        //int i = 123;
        var i = 123;
        String msg = "\t\"i\" = "; // String msg = new String("i = ");
        System.out.println(msg + i);
        //
        byte b = 1;
        b = (byte) (b + 1);
        System.out.println("b = " + b);
        System.out.println("done");
        */
        int x = 11;
        int y = 7;
        //
        int a = x + y;  // a = 18
        int s = x - y;  // s = 4
        int m = x * y;  // m = 77
        int d = x / y;  // d = 1
        int r = x % y;
        System.out.println("x=" + x + " y=" + y + " a=" + a + " s=" + s + " m=" + m + " d=" + d + " r=" + r + " double = " + (1.0 * x / y));
        System.out.println("(x++ + y) = " + (x++ + y) + "  x= " + x);
    }
}
