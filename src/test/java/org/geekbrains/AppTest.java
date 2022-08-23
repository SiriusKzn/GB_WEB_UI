package org.geekbrains;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.geekbrains.TriangleTest.squareTriangle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest
{
    @ParameterizedTest
    @CsvSource({"3,3,3,3.90","5,4,3,6.00", "7,9,11,31.42"})
    @DisplayName("Тест площади треугольника.")
    void TriangleTest(int a, int b, int c, double result) throws MyException {
        assertEquals(result, squareTriangle(a,b,c));
    }

    @ParameterizedTest
    @CsvSource({"3,0,3", "5,4,0", "-2,0,5"})
    @DisplayName("Негативный тест площади треугольника.")
    void TriangleNegativeTest(int a, int b, int c) throws MyException {
        Assertions.assertThrows(MyException.class,()->squareTriangle(a,b,c));
    }
}
