package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator cal = new Calculator();
        int a = 1234;
        int b = 5678;

        int result = cal.add(a,b);

        int expected = 6912;

        assertEquals(expected, result);


    }
}