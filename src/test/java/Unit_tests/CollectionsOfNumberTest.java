import Homework_JavaPart2.Task3;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CollectionsOfNumberTest {

    @Test
    public void testCalculateAverage() {
        ArrayList<Integer> testCollection = new ArrayList<>(Arrays.asList(10, 20, 30));
        double expectedAverage = 20.0;
        double actualAverage = Task3.calculateAverage(testCollection);
        assertEquals(expectedAverage, actualAverage, 0.001);
    }

    @Test
    public void testRemoveEvenNumbers() {
        ArrayList<Integer> testCollection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> expectedCollection = new ArrayList<>(Arrays.asList(1, 3, 5));
        Task3.removeEvenNumbers(testCollection);
        assertEquals(expectedCollection, testCollection);
    }

    @Test
    public void testContainsGivenNumber() {
        ArrayList<Integer> testCollection = new ArrayList<>(Arrays.asList(10, 20, 30));
        int givenNumber = 20;
        assertTrue(Task3.containsGivenNumber(testCollection, givenNumber));
    }

    @Test
    public void testDoesNotContainGivenNumber() {
        ArrayList<Integer> testCollection = new ArrayList<>(Arrays.asList(10, 20, 30));
        int givenNumber = 50;
        assertFalse(Task3.containsGivenNumber(testCollection, givenNumber));
    }
}
