package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.RightButTimeout;

import java.util.ArrayList;
import java.util.Arrays;
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

        Arrays.sort(nums);
        int res = nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                for (int k = j + 1; k < nums.length; ++k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return target;
                    }
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }
                }
            }
        }

        return res;
    }


    @RightButTimeout
    public int dfsSolution(int[] nums, int target) {
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
        int sum = path.stream().mapToInt(i -> i).sum();

        if (path.size() == 3) {
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
