package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;

/**
 * For a given sorted array (ascending order) and a target number, find the first index of this
 * number in O(log n) time complexity.
 *
 * <p>If the target number does not exist in the array, return -1.
 *
 * <p>Have you met this question in a real interview? Example If the array is [1, 2, 3, 3, 4, 5,
 * 10], for given target 3, return 2.
 *
 * <p>Challenge If the count of numbers is bigger than 2^32, can your code work properly?
 */
@FirstRound
@Easy
@LintCode
@Important
public class FirstPositionOfTarget {

  public int binarySearch(int[] nums, int target) {
    int res = -1;
    if (nums == null) {
      return res;
    }
    int start = 0;
    int end = nums.length - 1;
    // 1 折半搜索的关键点
    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (nums[middle] == target) {
        end = middle; // 如果要找到最左边的数字,如果找到就可以,那就BREAK;
      } else if (nums[middle] < target) {
        start = middle;
      } else if (nums[middle] > target) {
        end = middle;
      }
    }
    // 3 最后一定要判断 start end
    if (nums[start] == target) {
      return start;
    }
    if (nums[end] == target) {
      return end;
    }

    return res;
  }
}
