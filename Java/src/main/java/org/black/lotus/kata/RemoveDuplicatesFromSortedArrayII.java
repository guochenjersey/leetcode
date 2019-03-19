package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 *
 * <p>For example, Given sorted array nums = [1,1,1,2,2,3],
 *
 * <p>Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2
 * and 3. It doesn't matter what you leave beyond the new length.
 */
@LeetCode
@FirstRound
public class RemoveDuplicatesFromSortedArrayII {

  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int counter = 1;
    int[] res = new int[nums.length];
    res[0] = nums[0];
    int j = 1;
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] == nums[i - 1]) {

        if (counter < 2) {
          ++counter;
          res[j] = nums[i];
          ++j;
        }
      } else {
        res[j] = nums[i];
        ++j;
        counter = 1;
      }
    }

    System.arraycopy(res, 0, nums, 0, nums.length);

    return j;
  }
}
