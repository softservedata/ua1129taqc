package com.softserve.edu;

import com.softserve.edu07calc.Calc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AppTest {

    @Test
    public void testApp() {
        System.out.println("first test");
        Assertions.assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Ivan", "Petro"})
    public void checkHello(String name) {
        System.out.println("Hello " + name);
    }

    @ParameterizedTest
    @CsvSource({"5.1, 5, 10.1", "6, 4, 10"})
    public void checkAdd(double arg0, double arg1, double expected) {
        Calc calc = new Calc();
        double actual = 0;
        //
        actual = calc.add(arg0, arg1);
        Assertions.assertEquals(expected, actual, 0.001);
    }
}
