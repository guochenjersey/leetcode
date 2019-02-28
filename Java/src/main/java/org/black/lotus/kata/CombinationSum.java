package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.DFS;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
@LeetCode
@Medium
@DFS
@Accepted
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        helper(results, nums, path, target, 0, 0);

        return results;
    }

    private void helper(List<List<Integer>> results,
                        int[] nums,
                        List<Integer> path,
                        int target,
                        int sum,
                        int startIndex) {
        if (sum == target) {
            results.add(path);
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (i < startIndex) {
                // skip the passed path
                continue;
            }
            path.add(nums[i]);
            helper(results, nums, new ArrayList<>(path), target, sum + nums[i], i);
            path.remove(path.size() - 1);
        }
    }
}
