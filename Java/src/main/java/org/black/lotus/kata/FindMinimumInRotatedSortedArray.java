package org.black.lotus.kata;

import java.util.PriorityQueue;
import java.util.Queue;
import org.black.lotus.marker.*;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * <p>(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * <p>Find the minimum element.
 *
 * <p>You may assume no duplicate exists in the array.
 *
 * <p>Example 1:
 *
 * <p>Input: [3,4,5,1,2] Output: 1
 *
 * <p>Example 2:
 *
 * <p>Input: [4,5,6,7,0,1,2] Output: 0
 */
@LeetCode
@Medium
@FirstRound
@Accepted
@BinarySearch
public class FindMinimumInRotatedSortedArray {

  public int findMin(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int start = 0;
    int end = nums.length - 1;
    if (nums[start] < nums[end]) {
      // handle case like {0, 1, 2, 3, 4}
      return nums[start];
    }

    while (start + 1 < end) {
      int mid = (end + start) / 2;
      if (isMin(nums, mid)) {
        return nums[mid];
      }

      if (nums[end] < nums[mid]) {
        start = mid;
      }
      if (nums[start] > nums[mid]) {
        end = mid;
      }
    }

    if (isMin(nums, start)) {
      return nums[start];
    }

    if (isMin(nums, end)) {
      return nums[end];
    }

    return -1;
  }

  private boolean isMin(int[] nums, int pos) {
    if (pos - 1 >= 0
        && pos + 1 < nums.length
        && nums[pos] < nums[pos + 1]
        && nums[pos - 1] > nums[pos]) {
      return true;
    }

    if (pos == nums.length - 1 && nums[pos] < nums[pos - 1]) {
      return true;
    }

    return false;
  }

  /** O(n) complexity with heap setup. */
  @RightButTimeout
  private int findMinWithHeap(int[] nums) {
    Queue<Integer> pq = new PriorityQueue<>();
    for (int i : nums) {
      pq.offer(i);
    }

    return pq.poll();
  }
}
