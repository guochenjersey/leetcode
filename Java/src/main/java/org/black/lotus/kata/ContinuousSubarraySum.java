package org.black.lotus.kata;

import java.util.HashMap;
import java.util.Map;
import org.black.lotus.marker.*;

/**
 * Given a list of non-negative numbers and a target integer k, write a function to check if the
 * array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is,
 * sums up to n*k where n is also an integer.
 *
 * <p>Example 1: Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2, 4] is a
 * continuous subarray of size 2 and sums up to 6. Example 2: Input: [23, 2, 6, 4, 7], k=6 Output:
 * True Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * Note: The length of the array won't exceed 10,000. You may assume the sum of all the numbers is
 * in the range of a signed 32-bit integer.
 *
 * <p>如果是刷题老司机的话，遇到这种求子数组或者子矩阵之和的题，应该不难想到要建立累加和数组或者累加和矩阵来做。没错，这道题也得这么做，我们要遍历所有的子数组，
 * 然后利用累加和来快速求和。在得到每个子数组之和时，我们先和k比较，如果相同直接返回true，否则再判断，若k不为0，且sum能整除k，同样返回true，最后遍历结束返回false
 */
@LeetCode
@FirstRound
@Medium
@SubarraySum
@NoIdeaOrBadIdeaInitially
public class ContinuousSubarraySum {

  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int runningSum = 0;
    for (int i = 0; i < nums.length; ++i) {
      runningSum += nums[i];
      if (k != 0) {
        runningSum %= k;
      }

      Integer prev = map.get(runningSum);
      if ((prev != null)) {
        if (i - prev > 1) return true;
      } else {
        map.put(runningSum, i);
      }
    }
    return false;
  }

  public static void main(String... args) {
    int a = 100 % 9;
    int b = 200 % 9;
    int c = (a + 200) % 9;
    int d = (100 + 200) % 9;
    System.out.println(d + " " + c);
  }
}
