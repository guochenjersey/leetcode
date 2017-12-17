package org.black.lotus.lintcode;

public class FindMinInRotatedSortedArray {

  /** 0, 1, 2, 3, 4, 5, 6, 7 3, 4, 5, 6, 7, 0, 1, 2 */
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int start = 0;
    int end = nums.length - 1;
    int target = nums[nums.length - 1];

    // find the minimum element element less than target
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] <= target) {
        end = mid;
      } else {
        start = mid;
      }
    }

    if (nums[start] <= target) {
      return nums[start];
    } else {
      return nums[end];
    }
  }
}
