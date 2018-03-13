package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Google;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.Arrays;

/**
 *
 *
 * ﻿Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

 Return the difference between the sum of the two integers and the target.

 Example
 Given array nums = [-1, 2, 1, -4], and target = 4.

 The minimum difference is 1. (4 - (2 + 1) = 1).

 Challenge
 Do it in O(nlogn) time complexity.
 *
 * */
@FirstRound
@Medium
@LintCode
@Google
public class TwoSumClosestToTarget {

    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                min = Math.min(min, sum - target);
                --end;
            } else if (target - sum == 0) {
                return 0;
            } else {
                min = Math.min(min, target - sum);
                ++start;
            }
        }

        return min;
    }


    /**
     * The brutal force version
     * */
    public int twoSumClosest_lame(int[] nums, int target) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int distance = (target - (nums[i] + nums[j]));
                minSum = minSum < Math.abs(distance) ? minSum : Math.abs(distance);
            }
        }
        return minSum;
    }
}
