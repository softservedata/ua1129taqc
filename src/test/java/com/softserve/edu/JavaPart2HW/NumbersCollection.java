package com.softserve.edu.JavaPart2HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class NumbersCollection {
    public static void main(String[] args) {
        //random list
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100) + 1;
            myNumbers.add(randomNumber);
        }

        // Print the ArrayList
        System.out.println("Random numbers:");
        System.out.println(myNumbers);

        //min+max
        int minList = Collections.min(myNumbers);
        int maxList = Collections.max(myNumbers);

        System.out.println("Minimum value of list is: " + minList);
        System.out.println("Maximum value of list is: " + maxList);

        //given numbers
        int givenNumber = 50;
        boolean containsGivenNumber = myNumbers.contains(givenNumber);
        if (containsGivenNumber) {
            System.out.println("The collection contains the number " + givenNumber);
        } else {
            System.out.println("The collection does not contain the number " + givenNumber);
        }

        //sum of numbers
        int sum = 0;
        for (int num : myNumbers)
            sum += num;
        double average = (double) sum / myNumbers.size();
        System.out.println("Average value: " + average);

        // Remove even numbers
        for (int i = 0; i < myNumbers.size(); i++) {
            int even = myNumbers.get(i) % 2;
            if (even == 0) {
                System.out.println("This is Even Number:" + myNumbers.get(i));
                myNumbers.remove(i);
            }
        }

                // Print the even numbers
                Collections.sort(myNumbers);
                System.out.println("Sorted List: " + myNumbers);

        // Sort the collection in ascending order
        Collections.sort(myNumbers);

        // Print the sorted collection to the console
        System.out.println("Sorted collection:");
        System.out.println(myNumbers);
    }
}