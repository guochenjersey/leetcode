package org.black.lotus.kata;

import java.util.HashMap;
import java.util.Map;
import org.black.lotus.marker.*;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous
 * subarrays whose sum equals to k.
 *
 * <p>Example 1: Input:nums = [1,1,1], k = 2 Output: 2 Note: The length of the array is in range [1,
 * 20,000]. The range of numbers in the array is [-1000, 1000] and the range of the integer k is
 * [-1e7, 1e7].
 */
@FirstRound
@LeetCode
@Medium
@Important
public class SubArraySumEqualsK {

  public int subarraySum(int[] nums, int k) {
    int sum = 0, result = 0;
    Map<Integer, Integer> preSum = new HashMap<>();
    preSum.put(0, 1); // key initialization

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (preSum.containsKey(sum - k)) {
        result += preSum.get(sum - k);
      }
      preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
}
