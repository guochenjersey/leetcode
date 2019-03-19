package org.black.lotus.kata;

import org.black.lotus.marker.*;

@LeetCode
@FirstRound
@Easy
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int sum = nums[0];
    int res = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] > (nums[i] + sum)) {
        sum = nums[i];
      } else {
        sum += nums[i];
      }
      res = Math.max(res, sum);
    }

    return res;
  }
}
