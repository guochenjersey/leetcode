package org.black.lotus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all
 * unique triplets in the array which gives the sum of zero.
 *
 * <p>Note: The solution set must not contain duplicate triplets.
 *
 * <p>For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * <p>A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class Kata13 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int low = 0;
    int high = nums.length - 1;
    int lowNext = 1;
    // while (lowNext < high) {
    // if (nums[low] + nums[lowNext] + nums[high] > 0) {
    // --high;
    // } else if (nums[low] + nums[lowNext] + nums){
    //
    // }
    // }

    return res;
  }
}
