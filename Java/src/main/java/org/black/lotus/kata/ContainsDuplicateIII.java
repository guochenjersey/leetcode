package org.black.lotus.kata;

import java.util.Set;
import java.util.TreeSet;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute
 * difference between i and j is at most k.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,2,3,1], k = 3, t = 0 Output: true Example 2:
 *
 * <p>Input: nums = [1,0,1,1], k = 1, t = 2 Output: true Example 3:
 *
 * <p>Input: nums = [1,5,9,1,5,9], k = 2, t = 3 Output: false
 */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
@Important
public class ContainsDuplicateIII {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length < 2 || k < 1 || t < 0) return false;
    TreeSet<Long> helper = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      Long left = (long) nums[i] - t;
      Long right = (long) nums[i] + t + 1;
      /*  return set's value from [left, right)  */
      Set<Long> subSet = helper.subSet(left, right);
      if (!subSet.isEmpty()) return true;
      helper.add((long) nums[i]);
      if (i >= k) helper.remove((long) nums[i - k]);
    }
    return false;
  }
}
