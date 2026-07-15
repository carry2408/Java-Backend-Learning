package com.VR.Level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
        Calculator calculator = new Calculator();
    @Test
    void add() {
        assertEquals(10,calculator.add(10,0),()->"wrong add");
    }

    @Test
    void sub() {
        assertEquals(10,calculator.sub(15,5),()-> "Wrong sub");
    }

    @Test
    void mul() {
        assertEquals(75,calculator.mul(15,5),()-> "Wrong mul");
    }

    @Test
    void div() {
        assertEquals(3,calculator.div(15,5),()-> "Wrong div");
    }

    @Test
    void divByZero() {
        assertThrowsExactly(ArithmeticException.class,()-> calculator.div(10, 0));
    }
}