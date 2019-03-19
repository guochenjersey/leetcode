package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContinuousSubarraySumTest {

  @Test
  public void should_handle_zero() {
    int[] source = {0, 0};
    ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
    boolean res = continuousSubarraySum.checkSubarraySum(source, 0);
    assertEquals(true, res);
  }
}
