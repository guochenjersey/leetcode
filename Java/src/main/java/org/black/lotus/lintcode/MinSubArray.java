package org.black.lotus.lintcode;

import java.util.List;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

@FirstRound
@LintCode @Accepted
public class MinSubArray {

  public int minSubArray(List<Integer> nums) {
    if (nums == null || nums.size() == 0) {
      return 0;
    }

    int sum = 0, maxSum = 0, minSum = Integer.MAX_VALUE;
    for (Integer i : nums) {
      sum += i;
      minSum = Math.min(minSum, sum - maxSum);
      maxSum = Math.max(maxSum, sum);
    }

    return minSum;
  }
}
