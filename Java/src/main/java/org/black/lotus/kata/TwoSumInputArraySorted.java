package org.black.lotus.kata;

import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * Example
 * Given nums = [2, 7, 11, 15], target = 9
 * return [1, 2]
 *
 * Solution in my head:
 */
@FirstRound
@LeetCode
@NoIdeaOrBadIdeaInitially
@Amazon
public class TwoSumInputArraySorted {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                res[0] = ++start;
                res[1] = ++end;
                return res;
            } else if (sum < target) {
                ++start;
            } else if (sum > target) {
                --end;
            }
        }

        return res;
    }
}
