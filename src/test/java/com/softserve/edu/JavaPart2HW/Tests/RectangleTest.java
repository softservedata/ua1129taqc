package com.softserve.edu.JavaPart2HW.Tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.softserve.edu.JavaPart2HW.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTest {

    @Test
    public void rectangleTest() {
        // Arrange
        var width = 5;
        var height = 5;

        // Act
        var rectangle = new Rectangle(width, height);

        // Assert
        double expectedStandardAngle = 90.0;
        Assertions.assertEquals(width, rectangle.getWidth());
        Assertions.assertEquals(height, rectangle.getHeight());
        Assertions.assertEquals(expectedStandardAngle, rectangle.getAngle());
    }

    @Test
    public void rectangleAreaTest() {
        // Arrange
        var width = 5;
        var height = 5;
        var rectangle = new Rectangle(width, height);

        // Act
        var calculatedArea = rectangle.calculateArea();

        // Assert
        var expectedArea = 25;
        Assertions.assertEquals(expectedArea, calculatedArea);
    }

    @Test
    public void rectanglePerimeterTest(){
        // Arrange
        var width = 5;
        var height = 5;
        var rectangle = new Rectangle(width, height);

        //Act
        var calculatedPerimeter = rectangle.calculatePerimeter();

        //Assert
        var expectedPerimeter = 20;
        Assertions.assertEquals(expectedPerimeter, calculatedPerimeter);
    }

    @Test
    public void rectangleDiagonalTest(){
        // Arrange
        var width = 5;
        var height = 5;
        var rectangle = new Rectangle(width, height);

        //Act
        var calculatedDiagonal = rectangle.getDiagonal();

        //Assert
        var expectedDiagonal = 50;
        Assertions.assertEquals(expectedDiagonal, calculatedDiagonal);
    }
}
