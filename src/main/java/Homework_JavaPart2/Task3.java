package Homework_JavaPart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task3 {

    public static void main(String[] args) {

        ArrayList<Integer> numberCollection = new ArrayList<>();


        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100) + 1;
            numberCollection.add(randomNumber);
        }


        System.out.println("All elements of the collection:");
        System.out.println(numberCollection);


        int minNumber = Collections.min(numberCollection);
        int maxNumber = Collections.max(numberCollection);
        System.out.println("\nMinimum number: " + minNumber);
        System.out.println("Maximum number: " + maxNumber);


        double average = calculateAverage(numberCollection);
        System.out.println("\nAverage value: " + average);


        removeEvenNumbers(numberCollection);
        System.out.println("\nCollection after removing even numbers:");
        System.out.println(numberCollection);


        int givenNumber = 50;
        boolean containsGivenNumber = numberCollection.contains(givenNumber);
        System.out.println("\nDoes the collection contain " + givenNumber + "? " + containsGivenNumber);


        Collections.sort(numberCollection);
        System.out.println("\nSorted collection:");
        System.out.println(numberCollection);
    }


    private static double calculateAverage(ArrayList<Integer> collection) {
        int sum = 0;
        for (int number : collection) {
            sum += number;
        }
        return (double) sum / collection.size();
    }


    private static void removeEvenNumbers(ArrayList<Integer> collection) {
        collection.removeIf(number -> number % 2 == 0);
    }
}
