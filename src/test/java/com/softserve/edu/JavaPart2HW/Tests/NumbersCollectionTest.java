package com.softserve.edu.JavaPart2HW.Tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.softserve.edu.JavaPart2HW.NumbersCollection;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumbersCollectionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void GetRandomNumbersSizeTest() {
        //Act
        var numbers = NumbersCollection.GetRandomNumbers();

        //Assert
        var expectedCount = 20;
        Assertions.assertEquals(expectedCount, numbers.size());
    }
    @Test
    public void GetRandomNumbersWithRandomValuesTest() {
        //Act
        var numbers = NumbersCollection.GetRandomNumbers();
        var numbers2 = NumbersCollection.GetRandomNumbers();

        //Assert
        Assertions.assertNotEquals(numbers, numbers2);
    }

    @Test
    public void PrintMinValueTest() {
        // Arrange
        var numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);

        //Act
        NumbersCollection.PrintMinValue(numbers);

        //Assert
        assertEquals("Minimum value of list is: 1", outContent.toString().trim());
    }

    @Test
    public void PrintMaxValueTest() {
        // Arrange
        var numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);

        //Act
        NumbersCollection.PrintMaxValue(numbers);

        //Assert
        assertEquals("Maximum value of list is: 2", outContent.toString().trim());
    }

    @Test
    public void CheckIfElementExistAndPrintResultTest() {
        // Arrange
        var numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);

        //Act
        NumbersCollection.CheckIfElementExistAndPrintResult(1, numbers);

        //Assert
        assertEquals("The collection contains the number 1", outContent.toString().trim());
    }

    @Test
    public void CheckIfElementNotExistAndPrintResultTest() {
        // Arrange
        var numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);

        //Act
        NumbersCollection.CheckIfElementExistAndPrintResult(5, numbers);

        //Assert
        assertEquals("The collection does not contain the number 5", outContent.toString().trim());
    }

}