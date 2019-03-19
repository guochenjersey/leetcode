package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfSquareNumbersTest {

  @Test
  public void should_find_sum_of_square() {
    SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
    assertTrue(sumOfSquareNumbers.judgeSquareSum(0));
    assertFalse(sumOfSquareNumbers.judgeSquareSum(2147483646));
  }
}
