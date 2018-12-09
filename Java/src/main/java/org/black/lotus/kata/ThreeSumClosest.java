package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 Example:

 Given array nums = [-1, 2, 1, -4], and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
@LeetCode
@Medium
@FirstRound
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return -1;
        }

        List<Integer> path = new ArrayList<>();
        int res = nums[0] + nums[1] + nums[2];

        return helper(res, target, 0, nums, path);
    }

    private int helper(int res,
                       int target,
                       int index,
                       int[] nums,
                       List<Integer> path) {
        if (path.size() == 3) {
            int sum = path.stream().mapToInt(i -> i).sum();
            if (Math.abs(sum - target) < Math.abs(res - target)) {
                return sum;
            } else {
                return res;
            }
        }
        for (int i = index; i < nums.length; ++i) {
            List<Integer> p = new ArrayList<>(path);
            p.add(nums[i]);
            res = helper(res, target, i + 1, nums, p);
        }

        return res;
    }
}
