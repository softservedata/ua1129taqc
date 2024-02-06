package com.softserve.edu02;

public class Example2if {
    public static void main(String[] args) {
        /*
        int temperature = 45;
        if (temperature < 10) {
            System.out.println("if: It is too cold");
        } else if (temperature > 30) {
            System.out.println("if: It is Hot");
        } else {
            System.out.println("if: It is Ok");
        }
        */
        /*
        int temperature = 15;
        if (temperature < 10) {
            System.out.println("if: It is too cold");
        } else {
            System.out.println("if: It is Ok");
        }
        */
        /*
        int temperature = 15;
        String result = "";
        if (temperature < 10) {
            result = "if: It is too cold";
        } else {
            result = "if: It is Ok";
        }
        System.out.println(result);
        */
        int temperature = 15;
        String result = temperature < 10 ? "if: It is too cold" : "if: It is Ok";
        System.out.println(result);
    }
}
