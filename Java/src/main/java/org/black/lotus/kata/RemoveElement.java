package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.TwoPointer;

/**
 * Given an array and a value, remove all occurrences of that value in place and return the new
 * length.
 *
 * <p>The order of elements can be changed, and the elements after the new length don't matter.
 *
 * <p>Example Given an array [0,4,4,0,0,2,4,4], value=4
 *
 * <p>return 4 and front four elements of the array is [0,0,0,2]
 *
 * <p>Tags
 */
@FirstRound
@LintCode
@Easy
@TwoPointer
public class RemoveElement {

  public int removeElement(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int start = 0;
    int end = nums.length - 1;
    int counter = 0;
    while (start < end) {
      while (start < end && nums[start] != target) {
        ++start;
        ++counter;
      }

      while (start < end && nums[end] == target) {
        --end;
      }

      if (start < end) {
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
        ++start;
        ++counter;
      }
    }

    if (nums[start] != target) {
      return start + 1;
    } else {
      return start;
    }
  }
}
