package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * <p>Find all the elements that appear twice in this array.
 *
 * <p>Could you do it without extra space and in O(n) runtime?
 *
 * <p>Example: Input: [4,3,2,7,8,2,3,1]
 *
 * <p>Output: [2,3]
 */
@LeetCode
@Medium
@FirstRound
@NoIdeaOrBadIdeaInitially
public class FindAllDuplicatesInAnArray {

  public List<Integer> findDuplicates(int[] nums) {
    int length = nums.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      int val = Math.abs(nums[i]) - 1; // you can do this because 1 <= nums[i] <= nums.length
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      } else {
        list.add(Math.abs(nums[i]));
      }
    }

    return list;
  }
}
