package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShortestUnsortedContinuousSubArrayTest {

  @Test
  public void find_shortestUnsorted() {
    int[] source = {1, 3, 2, 4, 5};
    ShortestUnsortedContinuousSubArray shortestUnsortedContinuousSubArray =
        new ShortestUnsortedContinuousSubArray();
    int res = shortestUnsortedContinuousSubArray.findUnsortedSubarray(source);
  }
}
