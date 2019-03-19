package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class DegreeOfAnArrayTest {
  private DegreeOfAnArray degreeOfAnArray = new DegreeOfAnArray();

  @Test
  public void should_pass_test_case_1() {
    int[] nums = {1, 2, 2, 2, 3, 4, 5};
    assertEquals(3, degreeOfAnArray.findShortestSubArray(nums));
  }

  @Test
  public void should_pass_test_case_2() {
    int[] nums = {1, 2, 2, 3, 1, 4, 2};
    degreeOfAnArray.findShortestSubArray(nums);
  }

  @Test
  public void should_pass_test_case_3() {
    int[] nums = {1, 2, 2, 3, 1};
    assertEquals(2, degreeOfAnArray.findShortestSubArrayLintCode(nums));
  }
}
