package com.softserve.edu02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExampleSwitch {
    public static void main(String[] args) {
        System.out.print("Do you enjoy Java? (yes/no/maybe): ");
        String input = "error";
        try (Scanner sc = new Scanner(System.in)) {
            input = sc.nextLine();
        } catch (Exception e) {
            System.out.println("I/O Error.");
        }
        /*
        switch (input.toLowerCase()) {
            case "yes":
                //int i = 1/0;
                System.out.println("Ok!");
            case "maybe":
                System.out.println("Great!");
                break;
            case "no":
                System.out.println("Too bad!");
                break;
            default:
                System.out.println("Wrong!");
        }
        */
        //
        var result = switch (input.toLowerCase()) {
            case "yes", "maybe" -> "Great!_3";
            case "no" -> "Too bad!_3";
            default -> "Wrong!_3";
        };
        System.out.println("result = " + result);
        //
        /*
        String s = input.toLowerCase();
        if (s.equals("yes")) {
            System.out.println("Ok! 2");
        }
        if (s.equals("yes") || s.equals("maybe")) {
            System.out.println("Great! 2");
        } else if (s.equals("no")) {
            System.out.println("Too bad! 2");
        } else {
            System.out.println("Wrong! 2");
        }
        */
    }
}
