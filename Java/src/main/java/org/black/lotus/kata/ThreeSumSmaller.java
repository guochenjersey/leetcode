package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example
 * Example1
 *
 * Input:  nums = [-2,0,1,3], target = 2
 * Output: 2
 * Explanation:
 * Because there are two triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * Example2
 *
 * Input: nums = [-2,0,-1,3], target = 2
 * Output: 3
 * Explanation:
 * Because there are three triplets which sums are less than 2:
 * [-2, 0, 1]
 * [-2, 0, 3]
 * [-2, -1, 3]
 * */
@LintCode
@Medium
@FirstRound
@Accepted
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int res = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    ++j;
                } else {
                    --k;
                }
            }
        }

        return res;
    }
}
