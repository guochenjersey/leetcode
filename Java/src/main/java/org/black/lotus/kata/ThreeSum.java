package org.black.lotus.kata;

import java.util.*;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.Medium;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all
 * unique triplets in the array which gives the sum of zero.
 *
 * <p>Notice Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 *
 * <p>The solution set must not contain duplicate triplets.
 *
 * <p>Example For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *
 * <p>(-1, 0, 1) (-1, -1, 2)
 */
@FirstRound
@Medium
@Amazon
@Accepted
@Important
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();

    if (nums == null || nums.length < 3) {
      return results;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int target = 0 - nums[i];
      // remove duplicate here
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      for (int j = i + 1, k = nums.length - 1; j < k; ) {
        if (nums[j] + nums[k] == target) {
          List<Integer> result = new ArrayList<>(3);
          result.add(nums[i]);
          result.add(nums[j]);
          result.add(nums[k]);

          results.add(result);
          ++j;
          --k;

          // remove duplicate here
          while(j < k && nums[j] == nums[j - 1]) {
            ++j;
          }
          // remove duplicate here
          while (j < k && nums[k] == nums[k + 1]) {
            --k;
          }
        } else if (nums[j] + nums[k] < target) {
          ++j;
        } else {
          --k;
        }
      }
    }

    return results;
  }
}
