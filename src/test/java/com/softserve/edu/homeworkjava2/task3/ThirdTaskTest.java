package com.softserve.edu.homeworkjava2.task3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.softserve.edu.homeworkjava2.task3.ThirdTask.*;
import static org.junit.jupiter.api.Assertions.*;

public class ThirdTaskTest {

    @Test
    public void minNumber_should_return_correct_min_value() {
        // given
        List<Integer> numbers = List.of(2, -1, 27, -8, 2, -1, 0, -8);
        int expected = -8;

        // when
        int actual = minNumber(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void minNumber_should_return_correct_min_value_if_only_one_element_present() {
        // given
        List<Integer> numbers = List.of(2);
        int expected = 2;

        // when
        int actual = minNumber(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void minNumber_should_return_zero_if_collection_is_empty() {
        // given
        List<Integer> numbers = List.of();

        // when
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> minNumber(numbers)
        );

        // then
        assertEquals("Collection is empty", exception.getMessage());
    }

    @Test
    public void maxNumber_should_return_correct_max_value() {
        // given
        List<Integer> numbers = List.of(2, -1, 27, -8, 2, -1, 0, -8, 27);
        int expected = 27;

        // when
        int actual = maxNumber(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void maxNumber_should_return_correct_max_value_if_only_one_element_present() {
        // given
        List<Integer> numbers = List.of(-5);
        int expected = -5;

        // when
        int actual = maxNumber(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void maxNumber_should_return_zero_if_collection_is_empty() {
        // given
        List<Integer> numbers = List.of();

        // when
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> maxNumber(numbers)
        );

        // then
        assertEquals("Collection is empty", exception.getMessage());
    }
    @Test
    public void averageNumber_should_return_correct_average_int_value() {
        // given
        List<Integer> numbers = List.of(2, 6, 2, 6, 10, 10);
        int expected = 6;

        // when
        double actual = averageNumber(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void averageNumber_should_return_correct_average_double_value() {
        // given
        List<Integer> numbers = List.of(2, -1, 27, -8, 2, -25, 0, -8, 27);
        double expected = 1.7777777777777777;

        // when
        double actual = averageNumber(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void averageNumber_should_return_exception_if_collection_is_empty() {
        // given
        List<Integer> numbers = List.of();

        // when
        Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> averageNumber(numbers)
        );

        // then
        assertEquals("The average value cannot be calculated, since the collection is empty", exception.getMessage());
    }

    @Test
    public void averageNumber_should_return_correct_average_value_if_only_one_element_present() {
        // given
        List<Integer> numbers = List.of(10);

        int expected = 10;

        // when
        double actual = averageNumber(numbers);

        // then
        assertEquals(expected, actual);
    }

    @Test
    public void EvenNumbers_should_return_correct_collection_without_even_numbers() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(2, -1, 27, -8, 2, -1, 0, -8));
        List<Integer> expected = List.of(27, -1, -1);

        // when
        removeEvenNumbers(numbers);

        // then
        assertEquals(numbers.size(), expected.size());
        assertTrue(numbers.containsAll(expected));
    }

    @Test
    public void EvenNumbers_should_return_empty_collection_if_collection_contains_only_even_numbers() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(2, 26, 8, 2, 4, 0, 8));

        // when
        removeEvenNumbers(numbers);

        // then
        assertTrue(numbers.isEmpty());
    }

    @Test
    public void containsNumber_should_return_true_if_collection_contains_number() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(2, -1, 27, -8, 2, -1, 0, -8));

        // when
        boolean actual = containsNumber(numbers, 27);

        // then
        assertTrue(actual);
    }

    @Test
    public void containsNumber_should_return_false_if_collection_not_contains_number() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(2, -1, 27, -8, 2, -1, 0, -8));

        // when
        boolean actual = containsNumber(numbers, 100);

        // then
        assertFalse(actual);
    }
    @Test
    public void sort_should_return_sort_collection_in_ascending_order() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(2, -1, 27, -8, 2, -1, 0, -8));
        List<Integer> expected = List.of(-8, -8, -1, -1, 0, 2, 2, 27);

        // when
        sort(numbers);

        // then
        assertEquals(numbers, expected);
    }



}
