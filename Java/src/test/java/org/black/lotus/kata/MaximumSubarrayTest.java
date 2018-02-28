package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaximumSubarrayTest {

  private MaximumSubarray maximumSubarray;

  @Before
  public void setup() {
    maximumSubarray = new MaximumSubarray();
  }

  @Test
  public void should_find_maximum_subarray() {
    int[] nums = {0, 1, 2, -3, 4};
    int maximumSubArraySum = maximumSubarray.maxSubArray(nums);
    assertEquals(4, maximumSubArraySum);
  }

  @Test
  public void should_find_maximum_subarray_if_only_one_element() {
    int[] nums = {1};
    int maximumSubArraySum = maximumSubarray.maxSubArray(nums);
    assertEquals(1, maximumSubArraySum);
  }

  @Test
  public void should_find_maximum_subarray_if_only_two_element() {
    int[] nums = {1, 2};
    int maximumSubArraySum = maximumSubarray.maxSubArray(nums);
    assertEquals(3, maximumSubArraySum);
  }
}