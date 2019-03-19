package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NotAccepted;

/**
 * Given a unsorted array with integers, find the median of it.
 *
 * <p>A median is the middle number of the array after it is sorted.
 *
 * <p>If there are even numbers in the array, return the N/2-th number after sorted.
 *
 * <p>Example Given [4, 5, 1, 2, 3], return 3.
 *
 * <p>Given [7, 9, 4, 5], return 5.
 *
 * <p>Challenge O(n) time.
 *
 * <p>Quick select
 */
@FirstRound
@LintCode
@Easy
@NotAccepted
public class Median {

  public int median(int[] nums) {
    if (nums.length % 2 == 0) {
      return quickSelect(nums, 0, nums.length - 1, nums.length / 2 - 1);
    }
    return quickSelect(nums, 0, nums.length - 1, nums.length / 2 + 1);
  }

  private int quickSelect(int[] nums, int start, int end, int k) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = start;
    int right = end;
    int pivot = nums[(start + end) / 2];
    while (left <= right) {
      while ((left <= right && (nums[left] < pivot))) {
        ++left;
      }

      while (left <= right && (nums[right] > pivot)) {
        --right;
      }

      if (left <= right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        ++left;
        --right;
      }
    }

    if (start + k - 1 <= right) {
      return quickSelect(nums, start, right, k);
    }

    if (start + k - 1 >= left) {
      return quickSelect(nums, left, end, k - (left - start));
    }

    return nums[right + 1];
  }
}
