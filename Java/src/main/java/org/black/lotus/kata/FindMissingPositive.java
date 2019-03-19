package org.black.lotus.kata;

import java.util.Arrays;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,2,0] Output: 3 Example 2:
 *
 * <p>Input: [3,4,-1,1] Output: 2 Example 3:
 *
 * <p>Input: [7,8,9,11,12] Output: 1
 */
@LeetCode
@FirstRound
@Accepted
public class FindMissingPositive {

  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }
    Arrays.sort(nums);
    int start;
    int expected = 1;
    boolean isStart = false;
    for (int i : nums) {
      if (i <= 0) {
        continue;
      } else {
        if (!isStart) {
          isStart = true;
          if (i == 1) {
            start = 1;
          } else {
            return 1;
          }
          expected = start + 1;
          continue;
        }
      }
      if (i == expected) {
        ++expected;
      }
    }

    return expected;
  }
}
