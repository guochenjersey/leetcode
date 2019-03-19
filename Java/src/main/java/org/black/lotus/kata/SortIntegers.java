package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

/** Quick sort */
@FirstRound
@LintCode
@Medium
@Important
public class SortIntegers {

  public void sortIntegers(int[] nums) {
    if (nums == null || nums.length == 0) {
      return;
    }

    quickSort(nums, 0, nums.length - 1);
  }

  private void quickSort(int[] nums, int start, int end) {
    if (start >= end) {
      return;
    }

    int left = start;
    int right = end;
    int pivot = nums[(start + end) / 2];
    // note that it is left <=
    while (left <= right) {
      while (left <= right && nums[left] < pivot) {
        ++left;
      }

      while (left <= right && nums[right] > pivot) {
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

    quickSort(nums, start, right);
    quickSort(nums, left, end);
  }
}
