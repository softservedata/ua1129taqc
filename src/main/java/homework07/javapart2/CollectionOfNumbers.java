package homework07.javapart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/** Create an ArrayList that will store integers (Integer).
 Fill the collection with 20 random numbers from 1 to 100.
 Use the Random class to generate random numbers.
 1. Print all elements of the collection to the console.
 2. Find and print the minimum and maximum numbers in the collection.
 3. Calculate and print the average value of the numbers in the collection.
 4. Remove all even numbers from the collection, and then print the updated collection to the console.
 5. Check if the collection contains a given number (for example, 50), and print the result to the console.
 6. Sort the collection in ascending order and print the sorted collection to the console.
 */

public class CollectionOfNumbers {


    public static ArrayList<Integer> allRandomElements() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNumber = rand.nextInt(100) + 1;
            randomNumbers.add(randomNumber);
        } return randomNumbers;
    }

    public static double averageValueOfNumbers(ArrayList<Integer> numbers) {
        double sum = 0;
        for (int j : numbers) {
            sum += j;
        }
        return sum / numbers.size();
    }

    public static ArrayList<Integer> removingEvenNumbers(ArrayList<Integer> numbers){
        Iterator<Integer> num = numbers.iterator();
        while (num.hasNext()) {
            Integer i = num.next();
            if(i % 2 == 0){
                num.remove();
            }
        }
        return numbers;
    }

    public static boolean checkGivenNumber(ArrayList<Integer> numbers){
        int givenNumber = 35;
        boolean numberContains = numbers.contains(givenNumber);
        return numberContains;
    }

    public static ArrayList<Integer> sortCollection(ArrayList<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }



    public static void main(String[] args) {
        ArrayList<Integer> numberCollection = allRandomElements();

        // Print all elements of the collection to the console.
        System.out.println("ArrayList: " + numberCollection);

        // Find and print the minimum and maximum numbers in the collection.
        System.out.println("\nMinimum number in the collection: " + Collections.min(numberCollection) +
                "\nMaximum number in the collection: " + Collections.max(numberCollection));

        // Calculate and print the average value of the numbers in the collection.
        System.out.println("\nAverage value of the numbers in the collection: " + averageValueOfNumbers(numberCollection));

        // Remove all even numbers from the collection, and then print the updated collection to the console.
        System.out.println("\nCollection without even numbers: " + removingEvenNumbers(numberCollection));

        // Check if the collection contains a given number and print the result to the console.
        if (checkGivenNumber(numberCollection)){
                System.out.println("\nThe collection contains the given number");
            } else {
                System.out.println("\nThe collection doesn't contain the given number");
            }

        // Sort the collection in ascending order and print the sorted collection to the console.
            System.out.println("\nSorted collection: " + sortCollection(numberCollection));
        }

        }


