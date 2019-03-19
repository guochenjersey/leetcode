package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 *
 * <p>Notice You must do this in-place without making a copy of the array. Minimize the total number
 * of operations. Example Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be
 * [1, 3, 12, 0, 0].
 */
@FirstRound
@LintCode
public class MoveZeroes {

  public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      for (int j = i; j < nums.length; ++j) {
        if (nums[j] == 0 && (j + 1 < nums.length)) {
          nums[j] = nums[j + 1];
          nums[j + 1] = 0;
        }
      }
    }
  }
}
