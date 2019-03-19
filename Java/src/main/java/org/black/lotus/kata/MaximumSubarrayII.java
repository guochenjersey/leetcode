package org.black.lotus.kata;

import java.util.List;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Given an array of integers, find two non-overlapping subarrays which have the largest sum. The
 * number in each subarray should be contiguous. Return the largest sum.
 *
 * <p>Notice The subarray should contain at least one number
 *
 * <p>Example For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3,
 * -1, 2] and [2], they both have the largest sum 7.
 *
 * <p>Challenge Can you do it in time complexity O(n) ?
 */
@LintCode
@FirstRound
public class MaximumSubarrayII {

  public int maxTwoSubArrays(List<Integer> nums) {
    int sum = 0;
    int minSum =
        0; // why minSum is 0 here? rather than Integer.Max_VALUE, because minSum should only start
    // counting when there is negative number in the array
    int maxSum = Integer.MIN_VALUE;
    int numsSize = nums.size();
    int[] left = new int[numsSize];
    int[] right = new int[numsSize];

    for (int i = 0; i < numsSize; ++i) {
      sum += nums.get(i);
      maxSum = Math.max(maxSum, sum - minSum);
      minSum = Math.min(minSum, sum);
      left[i] = maxSum;
    }

    sum = 0;
    minSum = 0;
    maxSum = Integer.MIN_VALUE;
    for (int i = numsSize - 1; i >= 0; --i) {
      sum += nums.get(i);
      maxSum = Math.max(maxSum, sum - minSum);
      minSum = Math.min(minSum, sum);
      right[i] = maxSum;
    }

    maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < numsSize - 1; ++i) {
      maxSum = Math.max(maxSum, left[i] + right[i + 1]);
    }

    return maxSum;
  }
}
