package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.NotAccepted;

@NoIdeaOrBadIdeaInitially
@NotAccepted
@LintCode @FirstRound
public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // min sum. careful about the initial value set, minSum should be 0
    int maxSum = Integer.MIN_VALUE, minSum = 0, sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      maxSum = Math.max(maxSum, sum - minSum);
      // min sum calculation should be after max sum because we are finding sub array
      minSum = Math.min(minSum, sum);
    }

    return maxSum;
  }
}
