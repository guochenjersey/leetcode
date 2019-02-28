package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
@LeetCode
@Medium
@FirstRound
@DFS
@Accepted
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Set<List<Integer>> results = new HashSet<>();
        if (nums == null) {
            return new ArrayList<>(results);
        }
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        helper(results, path, target, 0, nums, 0);
        return new ArrayList<>(results);
    }


    private void helper(Set<List<Integer>> results,
                        List<Integer> path,
                        int target,
                        int sum,
                        int[] nums,
                        int startIndex) {
        if (sum == target) {
            results.add(path);
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < nums.length; ++i) {
            path.add(nums[i]);
            helper(results, new ArrayList<>(path), target, sum + nums[i], nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
