package org.black.lotus.kata;

import java.util.Arrays;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * <p>Your function should return true if any value appears at least twice in the array, and it
 * should return false if every element is distinct.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,2,3,1] Output: true Example 2:
 *
 * <p>Input: [1,2,3,4] Output: false Example 3:
 *
 * <p>Input: [1,1,1,3,3,4,3,2,4,2] Output: true
 */
@FirstRound
@LeetCode
@Easy
public class ContainsDuplicate {

  public boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    Arrays.sort(nums);
    int current = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      if (current == nums[i]) {
        return true;
      } else {
        current = nums[i];
      }
    }

    return false;
  }
}
