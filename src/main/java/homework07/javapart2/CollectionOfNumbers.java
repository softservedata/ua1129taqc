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

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();

        for (int i=0; i<20; i++) {
            int randomNumbers = rand.nextInt(100) + 1;
            numbers.add(randomNumbers);
            }
        System.out.println("ArrayList: " + numbers);
        System.out.println("Minimum number in the collection: " + Collections.min(numbers) +
                "\nMaximum number in the collection: " + Collections.max(numbers));

        double sum = 0;
        for(int j : numbers){
            sum += sum + j;
        }
        double averageValue = sum / numbers.size();
        System.out.println("Average value of the numbers in the collection: " + averageValue);

        Iterator<Integer> num = numbers.iterator();
        while (num.hasNext()) {
            Integer i = num.next();
            if(i % 2 == 0){
                num.remove();
            }
        } System.out.println("Collection without even numbers: " + numbers);

            int givenNumber = 35;
            boolean numberContains = numbers.contains(givenNumber);
            if (numberContains){
                System.out.println("The collection contains the given number " + givenNumber);
            } else {
                System.out.println("The collection doesn't contain the given number " + givenNumber);
            }

            Collections.sort(numbers);
            System.out.println("Sorted collection: " + numbers);
        }

        }


