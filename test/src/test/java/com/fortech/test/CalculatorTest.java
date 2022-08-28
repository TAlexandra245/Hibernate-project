package com.fortech.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculatorTest {

    private Calculator calculator = new Calculator();
    private Calculator mockCalculator = Mockito.mock(Calculator.class);
    @Test
    public void testAdd() {
        Integer sum = calculator.add(2,3);
        Assertions.assertEquals(5,sum,"Error");

    }

    @Test
    public void testAddMockito() {
        Mockito.when(mockCalculator.add(2, 3)).thenReturn(5);
        Mockito.when(mockCalculator.add(3,4)).thenReturn(10);
        Integer sum = mockCalculator.add(2,3);
        Assertions.assertEquals(5,sum);
        Integer addSum = mockCalculator.add(3,4);
        Assertions.assertEquals(10,addSum);
        Integer thirdSum = mockCalculator.add(6,7);
        Assertions.assertEquals(0,thirdSum);
    }
}
