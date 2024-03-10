package com.softserve.edu.homework02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CollectionOfNumbers {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<Integer>();

        Random random = new Random();
        int sum = 0;
        int numberToFind = 50;


        for (int i = 0; i < 20; i++)
        {
            int index = random.nextInt(1, 100);
            myList.add(index);
            sum += myList.get(i);
        }

        System.out.println("Randomly generated elements from 1 to 100 using ArrayList:\n" + myList);
        System.out.println("Min number in ArrayList: " + Collections.min(myList));
        System.out.println("Max number in ArrayList: " + Collections.max(myList));
        System.out.println("The average of numbers in ArrayList: " + sum / myList.size());
        System.out.println("ArrayList contains number " + numberToFind + ": " + myList.contains(numberToFind));

        Collections.sort(myList);

        System.out.println("Sorted ArrayList:\n" + myList);

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i) % 2 == 0){
                myList.remove(i);
                i--;
            };
        }

        System.out.println("ArrayList without even numbers:\n" + myList);

    }
}
