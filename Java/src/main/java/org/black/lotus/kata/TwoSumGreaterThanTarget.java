package org.black.lotus.kata;

import java.util.Arrays;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Google;
import org.black.lotus.marker.HaveNotCheckAnswer;

/**
 * Given an array of integers, find how many pairs in the array such that their sum is bigger than a
 * specific target number. Please return the number of pairs.
 *
 * <p>Have you met this question in a real interview? Example Given numbers = [2, 7, 11, 15], target
 * = 24. Return 1. (11 + 15 is the only pair)
 *
 * <p>Challenge Do it in O(1) extra space and O(nlogn) time.
 *
 * <p>Tags Related Problems
 */
@Google
@Accepted
@HaveNotCheckAnswer
public class TwoSumGreaterThanTarget {

  public int twoSum2TwoPointer(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    Arrays.sort(nums);

    int left = 0, right = nums.length - 1;
    int count = 0;
    while (left < right) {
      if (nums[left] + nums[right] <= target) {
        left++;
      } else {
        count += right - left;
        right--;
      }
    }

    return count;
  }

  public int twoSum2(int[] nums, int target) {
    Integer[] sortedNums =
        Arrays.stream(nums).boxed().sorted((o1, o2) -> o2 - o1).toArray(Integer[]::new);

    int result = 0;

    for (int i = 0; i < sortedNums.length; ++i) {
      for (int j = i + 1; j < sortedNums.length; ++j) {
        if (sortedNums[i] + sortedNums[j] <= target) {
          break;
        }
        ++result;
      }
    }
    return result;
  }
}
