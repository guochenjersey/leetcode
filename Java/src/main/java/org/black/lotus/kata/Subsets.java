package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (51.36%)
 * Total Accepted:    337.8K
 * Total Submissions: 657.8K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
@LeetCode
@Medium
@Accepted
public class Subsets {
  /*
   * DFS search all possible results.
   */
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      res.add(new ArrayList<>());
      if (nums == null || nums.length == 0) {
          return res;
      }
      Arrays.sort(nums);
      List<Integer> path = new ArrayList<>();

      helper(path, res, nums, 0);
      return res;
  }

    private void helper(List<Integer> path,
                        List<List<Integer>> res,
                        int[] nums,
                        int currentIndex) {
        if (currentIndex > nums.length - 1) {
            return;
        }
        for (int i = currentIndex; i < nums.length; ++i) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            helper(new ArrayList<>(path), res, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
