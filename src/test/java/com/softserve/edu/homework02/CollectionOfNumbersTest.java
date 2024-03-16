package com.softserve.edu.homework02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionOfNumbersTest {

    private static CollectionOfNumbers myCollectionOfNumbers;

    @BeforeAll
    public static void setup() {
        myCollectionOfNumbers = new CollectionOfNumbers();
    }

    @Test
    public void checkSize() {
        List<Integer> actualCollection = myCollectionOfNumbers.getIntegerCollection();
        Assertions.assertEquals(20, actualCollection.size(), "Expected size is 20");
    }

    @Test
    void checkRange() {
        List<Integer> actualCollection = myCollectionOfNumbers.getIntegerCollection();

        for (int current : actualCollection) {
            Assertions.assertTrue(current >= 1 && current <= 100, "Expected Range is from 1 to 100");
        }
    }

    @Test
    void checkEvenNumbersInCollection() {
        List<Integer> actualCollection = myCollectionOfNumbers.getIntegerCollectionWithoutEvenNumbers();

        for (int current : actualCollection) {
            Assertions.assertFalse(current % 2 == 0, "Collection doesn't contain even numbers");
        }
    }

    @Test
    void sortCollection() {
        List<Integer> actualCollection = myCollectionOfNumbers.getSortedIntegerCollection();

        for (int i = actualCollection.size() - 1; i > 0; i--) {
            Assertions.assertTrue(actualCollection.get(i) >= actualCollection.get(i - 1), "Collection is sorted");
        }
    }
}