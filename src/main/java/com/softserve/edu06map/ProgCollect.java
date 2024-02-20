package com.softserve.edu06map;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProgCollect {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("second", "third", "fourth", "first", "first");
        System.out.println("Original list = " + list);
        Collections.reverse(list);
        System.out.println("Reverse list = " + list);

        // sorting
        Collections.sort(list);
        System.out.println("Sorted list = " + list);

        //reverse sort order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sorted reverseOrder list = " + list);

        // uses a binary search algorithm to find a specific element;
        // returns the element number or a negative number
        Collections.sort(list);
        System.out.println("Sorted list = " + list);
        System.out.println("binarySearch = " + Collections.binarySearch(list, "second"));

        //randomly reorders elements
        Collections.shuffle(list);
        System.out.println("shuffle list = " + list);

        // max value, min value,
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));

        // cyclically shifts the elements passed to it by distance
        // positions forward (+) or backward (-)
        Collections.rotate(list, -1);
        System.out.println("rotate list = " + list);

        // copy collection
        List<String> listDestination = Arrays.asList("green", "black");
        Collections.copy(list, listDestination);
        System.out.println("updated = " + list);

        // returns the total number of occurrences of the
        // specified element in the list
        System.out.println("frequency first = " + Collections.frequency(list, "first"));
    }
}
