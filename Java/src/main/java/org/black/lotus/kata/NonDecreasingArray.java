package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Given an array with n integers, your task is to check if it could become non-decreasing by
 * modifying at most 1 element.
 *
 * <p>We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i <
 * n).
 *
 * <p>Example 1: Input: [4,2,3] Output: True Explanation: You could modify the first 4 to 1 to get a
 * non-decreasing array. Example 2: Input: [4,2,1] Output: False Explanation: You can't get a
 * non-decreasing array by modify at most one element. Note: The n belongs to [1, 10,000].
 */
@LeetCode
@Easy
@NoIdeaOrBadIdeaInitially
public class NonDecreasingArray {

  public boolean checkPossibility(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }
    boolean skipedOnce = false;
    for (int i = 0; i < nums.length; ++i) {
      if (i + 1 < nums.length) {
        if (nums[i] <= nums[i + 1]) {
          continue;
        } else {
          if (skipedOnce) {
            return false;
          }
          if ((i + 1) == (nums.length - 1)) {
            return true;
          }
          skipedOnce = true;
          int nextPos = findValid(nums, i);
          if (nextPos != -1) {
            i = nextPos;
          } else {
            return false;
          }
        }
      }
    }

    return true;
  }

  private int findValid(int[] nums, int i) {
    // if skip i + 1
    if (i + 2 < nums.length) {
      if (nums[i] <= nums[i + 2]) {
        return i + 1;
      }
    }

    // if skip i
    if (i - 1 >= 0) {
      if (nums[i - 1] <= nums[i + 1]) {
        return i;
      }
    } else {
      return i;
    }

    return -1;
  }
}
