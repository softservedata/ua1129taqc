package com.softserve.edu.JavaPart2HW.Tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.softserve.edu.JavaPart2HW.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RectangleTest {

    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "7, 7",
            "9, 9"
    })
    public void rectangleTest(double height, double width) {
        // Act
        var rectangle = new Rectangle(width, height);

        // Assert
        double expectedStandardAngle = 90.0;
        Assertions.assertEquals(width, rectangle.getWidth());
        Assertions.assertEquals(height, rectangle.getHeight());
        Assertions.assertEquals(expectedStandardAngle, rectangle.getAngle());
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 25",
            "7, 7, 49",
            "9, 9, 81"
    })
    public void rectangleAreaTest(double width, double height, double expectedArea) {
        // Arrange
        var rectangle = new Rectangle(width, height);

        // Act
        var calculatedArea = rectangle.calculateArea();

        // Assert
        Assertions.assertEquals(expectedArea, calculatedArea);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 16",
            "7, 4, 22",
            "9, 7, 32"
    })
    public void rectanglePerimeterTest(double width, double height, double expectedPerimeter){
        // Arrange
        var rectangle = new Rectangle(width, height);

        //Act
        var calculatedPerimeter = rectangle.calculatePerimeter();

        //Assert
        Assertions.assertEquals(expectedPerimeter, calculatedPerimeter);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3,5.830951894845301",
            "7, 4, 8.06225774829855",
            "9, 7, 11.40175425099138"
    })
    public void rectangleDiagonalTest(double width, double height, double expectedDiagonal){
        // Arrange

        var rectangle = new Rectangle(width, height);

        //Act
        var calculatedDiagonal = rectangle.getDiagonal();

        //Assert
        Assertions.assertEquals(expectedDiagonal, calculatedDiagonal);
    }
}
