package unitTest;

import homework07.javapart2.CollectionOfNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collections;

public class CollectionOfNumbersTests {

    private ArrayList<Integer> numbers;

    @BeforeEach
    void arrList(){
        numbers = new ArrayList<>();
    }

    @Test
    void testCheckSizeCollectionOfNumbers() {
        ArrayList<Integer> actualCollection = CollectionOfNumbers.allRandomElements();
        Assertions.assertEquals(20, actualCollection.size(), "Collection should have size 20 elements");
    }

    @Test
    void testGivenLimitsOfElements (){
        ArrayList<Integer> actualCollection = CollectionOfNumbers.allRandomElements();
        for (int number : actualCollection) {
            Assertions.assertTrue(number >= 1 && number <= 100);
        }
    }

    @Test
    void testMinAndMaxNumbers (){
        numbers.add(56);
        numbers.add(2);
        numbers.add(12);
        numbers.add(35);
     Assertions.assertEquals(2, Collections.min(numbers));
     Assertions.assertEquals(56,Collections.max(numbers));
    }

    @Test
    void testAverageOfNumbers () {
        Collections.addAll(numbers, 1,2,3,4,5,6,7);
        double average = CollectionOfNumbers.averageValueOfNumbers(numbers);
        Assertions.assertEquals(4, average, 0.001);
    }

    @Test
    void testRemovingEvenNumbers () {
        Collections.addAll(numbers, 2, 5, 8, 5, 10, 34, 89);
        ArrayList<Integer> numbersWithoutEven = CollectionOfNumbers.removingEvenNumbers(numbers);
        ArrayList<Integer> expectedResult = new ArrayList<>();
        Collections.addAll(expectedResult, 5, 5, 89);
        Assertions.assertEquals(expectedResult, numbersWithoutEven);
    }

    @Test
    void testCheckGivenNumber (){
        Collections.addAll(numbers, 35,78,32,16,90);
        Assertions.assertTrue(CollectionOfNumbers.checkGivenNumber(numbers));
    }

    @Test
    void testSortCollection (){
        Collections.addAll(numbers, 1,6,8,2,4,7);
        ArrayList<Integer> actualResult = CollectionOfNumbers.sortCollection(numbers);
        ArrayList<Integer> sortedNumbers = new ArrayList<>();
        Collections.addAll(sortedNumbers, 1,2,4,6,7,8);
        Assertions.assertIterableEquals(actualResult, sortedNumbers);
     }

}
