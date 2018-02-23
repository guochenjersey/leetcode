package org.black.lotus.lintcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarray {

  public int maxSubArray(int[] nums) {
    int sum = 0, prevSum = 0, startPoint = 0, maxSum = 0;

    Map<Integer, Integer> sumsMap = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      sumsMap.put(i, sum);
      if (sum >= prevSum) {
        prevSum = sum;
      } else {
        startPoint = i;
      }
      Integer startPointSum = sumsMap.get(startPoint);
      maxSum = Math.max(prevSum - startPointSum, maxSum);
    }

    return maxSum;
  }
}
