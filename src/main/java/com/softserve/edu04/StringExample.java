package com.softserve.edu04;

public class StringExample {
    private static String str = "Hello Java!";
    private String str2; // = "Hello World!";

    static {
        System.out.println("Static Block, str =" + str);
    }

    public StringExample(String str2) {
        this.str2 = str2;
        System.out.println("Constructor done");
    }

    public String getStr2() {
        return str2;
    }

    public static void main(String[] args) {
        StringExample s = new StringExample("Privet");
        System.out.println("Hello from the method 'main',\nstr = " + str + "  str2 = " + s.getStr2() );
    }
}
