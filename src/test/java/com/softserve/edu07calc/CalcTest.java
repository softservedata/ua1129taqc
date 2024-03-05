package com.softserve.edu07calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalcTest {

    @Test
    public void checkAddEq() {
        Calc calc = new Calc();
        double actual = 0;
        double expected = 10;
        //
        actual = calc.add(5, 5);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void checkAddNEq() {
        Calc calc = new Calc();
        double actual = 0;
        double expected = 10;
        //
        actual = calc.add(6, 4);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    //@Test
    @ParameterizedTest
    @CsvSource({"5,5,10", "6,4,10"})
    public void checkAdd(double arg0, double arg1, double expected) {
        Calc calc = new Calc();
        double actual = 0;
        //double expected = 10;
        //
        actual = calc.add(arg0, arg1);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void checkDivInt() {
        Calc calc = new Calc();
        double actual = 0;
        double expected = 5;
        //
        actual = calc.div(20, 4);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void checkDivFlo() {
        Calc calc = new Calc();
        double actual = 0;
        double expected = 2.5001;
        //
        actual = calc.div(20, 8);
        Assertions.assertEquals(expected, actual, 0.001);
    }
}
