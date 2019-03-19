package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapifyTest {

  @Test
  public void should_find_min_heap() {
    Heapify heapify = new Heapify();
    int[] nums = {39, 32, 45, 67, 21, 34, 89, 91, 24};
    heapify.heapify(nums);
  }
}
