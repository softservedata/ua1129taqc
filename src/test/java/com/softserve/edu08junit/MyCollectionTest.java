package com.softserve.edu08junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MyCollectionTest {

    private static MyCollection myCollection;

    @BeforeAll
    public static void setup() {
        myCollection = new MyCollection();
    }

    @Test
    public void checkSize() {
        List<String> actualCollection = myCollection.getStringCollection();
        Assertions.assertEquals(3, actualCollection.size());
    }

    @Test
    public void checkContent() {
        List<String> expectedCollection = Arrays.asList("Alex", "Anna", "Natalya");
        List<String> actualCollection = myCollection.getStringCollection();
        Assertions.assertEquals(expectedCollection, actualCollection);
    }
}
