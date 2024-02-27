import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class ArrayNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100);
            Numbers.add(randomNumber);

            System.out.println("Random number " + randomNumber);
            System.out.println(Numbers);

        }

        int minValue = Collections.min(Numbers);
        int maxValue = Collections.max(Numbers);

        // Print the results
        System.out.println("Minimum value: " + minValue);
        System.out.println("Maximum value: " + maxValue);


        int sum = 0;
        for (int number : Numbers) {
            sum += number;

            double average = (double) sum / Numbers.size();
            System.out.println("Average=" + average);
        }
        for (int i = 0; i < Numbers.size(); i++) {
            int even = Numbers.get(i) % 2;
            if (even == 0) {
                System.out.println("Only Even Numbers in Collection:" + Numbers.get(i));
                Numbers.remove(i);
            }
            Collections.sort(Numbers);
            System.out.println("Sorted List: " + Numbers);

            // Sort
            Collections.sort(Numbers);


            System.out.println("Sorted numbers:");
            System.out.println(Numbers);
        }
        }
    }
