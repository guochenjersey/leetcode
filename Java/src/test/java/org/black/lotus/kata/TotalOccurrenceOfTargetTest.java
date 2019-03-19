package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class TotalOccurrenceOfTargetTest {

  @Test
  public void should_calculate_total_occurance() {
    int[] nums = {0, 1, 2, 3, 3, 3, 4, 5, 6};
    TotalOccurrenceOfTarget totalOccurrenceOfTarget = new TotalOccurrenceOfTarget();
    int totalOccurance = totalOccurrenceOfTarget.totalOccurrence(nums, 3);
    assertEquals(3, totalOccurance);
  }

  @Test
  public void should_find_all_occurance() {
    int[] nums = {0, 1, 2, 3, 4, 5};
  }
}
