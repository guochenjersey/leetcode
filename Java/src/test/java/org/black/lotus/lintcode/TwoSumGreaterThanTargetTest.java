package org.black.lotus.lintcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumGreaterThanTargetTest {

  private TwoSumGreaterThanTarget twoSumGreaterThanTarget
      = new TwoSumGreaterThanTarget();

  @Test
  public void test_case_1() {
    int[] nums = {2, 7, 11, 15};
    assertEquals(1, twoSumGreaterThanTarget.twoSum2(nums, 24));
  }

  @Test
  public void test_case_2() {
    int[] nums = {2, 7, 11, 15};
    assertEquals(5, twoSumGreaterThanTarget.twoSum2TwoPointer(nums, 9));
  }
}