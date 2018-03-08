package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

import java.util.Arrays;

/**
 * Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

 Have you met this question in a real interview?
 Example
 Given nums = [2, 7, 11, 15], target = 24.
 Return 5.
 2 + 7 < 24
 2 + 11 < 24
 2 + 15 < 24
 7 + 11 < 24
 7 + 15 < 25

 Tags
 *
 * solution: two pointer fix one side and move another, adjusting reference by own logic
 *
 * */
@FirstRound
@LintCode
@Accepted
public class TwoSumLessThanOrEqualToTarget {

    public int twoSum5(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = nums.length - 1; i < j;) {
                if (nums[i] + nums[j] <= target) {
                    res += (j - i);
                    break;
                } else {
                    --j;
                }
            }
        }

        return res;
    }
}
