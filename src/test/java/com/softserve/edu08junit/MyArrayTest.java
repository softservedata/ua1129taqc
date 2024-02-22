package com.softserve.edu08junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyArrayTest {

    @Test
    public void checkArraySize() {
        Assertions.assertEquals(5, MyArray.createArray().length, "Array should have size 5");
    }

    @Test
    public void checkArrayContent() {
        int[] expected = {1, 2, 3, 4, 5};
        //int[] expected = {1, 2, 3, 5, 4};
        int[] actual = MyArray.createArray();
        Assertions.assertArrayEquals(expected, actual, "Array shouldbe equal");
    }

    @Test
    public void checkArrayContent2() {
        int[] expectedArray = {1, 2, 3, 5, 4};
        int[] actualArray = MyArray.createArray();
        //
        Set<Integer> expected = new HashSet<>();
        for (int num : expectedArray) {
            expected.add(num);
        }
        Set<Integer> actual = new HashSet<>();
        for (int num : actualArray) {
            actual.add(num);
        }
        Assertions.assertTrue(expected.equals(actual), "Array shouldbe equal");
    }

    public static Object[] arrayProvider() {
        return new Object[]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{5, 4, 3, 2, 1},
                new int[]{1, 2, 3, 4, 10}
        };
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    public void checkArrayProvider(int[] expectedArray) {
        int[] actualArray = MyArray.createArray();
        //Arrays.sort(expectedArray);
        Assertions.assertArrayEquals(expectedArray, actualArray, "Array should be equal");
    }


    public static Object[][] arrayExistNumber() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 3},
                {new int[]{5, 4, 3, 2, 1}, 14},
                {new int[]{1, 2, 3, 4, 10}, 10}
        };
    }

    @ParameterizedTest
    @MethodSource("arrayExistNumber")
    public void checkarrayExistNumber(int[] arr, int num) {
        Assertions.assertTrue(MyArray.arrayContainsNumber(arr, num), "Array should contain the number");
    }
}
