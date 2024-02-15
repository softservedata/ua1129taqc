package com.softserve.edu05list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AppLst {
    public static void main(String[] args) {
        //int[] numbers = { 2, -5, 8, -4, 7 };
        /*
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(-5);
        numbers.add(8);
        numbers.add(-4);
        numbers.add(7);
        System.out.println("Origin List = " + numbers);
        numbers.add(9);
        System.out.println("new List = " + numbers);
        System.out.println("numbers.get(2) = " + numbers.get(2));
        numbers.set(2,-8);
        System.out.println("new2 List = " + numbers);
        */
        /*
        List numbers = new ArrayList(); // List<Object>
        numbers.add(2);
        numbers.add(-5);
        System.out.println("Origin List = " + numbers);
        */
        // /*
        List<String> list = new LinkedList<>();
        list.add("First element");  // Adding elements
        list.add("Second element");
        list.add("Third element");
        list.add("Fourth element");
        System.out.println("List1 = " + list);
        list.add(0, "One more first element");
        System.out.println("List2 = " + list);
        //
        //list.remove("First element");
        //list.remove(1);
        //System.out.println("List3 = " + list);
        //
        //list<String> removeElements = List.of("First element", "Fourth element");
        //list.removeAll(removeElements);
        //System.out.println("List4 = " + list);
        //
        List<String> retainElements = List.of("First element", "Fourth element");
        list.retainAll(retainElements);
        System.out.println("List5 = " + list);
        // */
        /*
        //Integer[] numbers = { 2, -5, 8, -4, 7 };
        //List<Integer> list = Arrays.asList(numbers);
        List<Integer> list = List.of(2, -5, 8, -4, 7);
        System.out.println("List = " + list);
        */
    }
}
