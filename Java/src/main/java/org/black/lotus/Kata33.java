package org.black.lotus;

/**
 *
 *
 * <pre>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 * </pre>
 */
public class Kata33 {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == -1) {
      return -1;
    }
    int targetIndex = -1;

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      }
    }

    return targetIndex;
  }
}
