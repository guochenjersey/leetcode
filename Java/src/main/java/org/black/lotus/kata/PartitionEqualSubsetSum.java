package org.black.lotus.kata;

import org.black.lotus.marker.DP;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.TLESolution;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * <p>
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
@LeetCode
@Important
@FirstRound
@DP
@NoIdeaOrBadIdeaInitially
public class PartitionEqualSubsetSum {

    @TLESolution
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean takei = helper(nums, 1, nums[0], sum / 2);
        boolean skipi = helper(nums, 1, 0, sum / 2);

        return takei || skipi;
    }

    private boolean helper(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            return sum == target;
        }
        if (i + 1 < nums.length) {
            return helper(nums, i + 1, sum + nums[i + 1], target)
                    || helper(nums, i + 1, sum, target);
        } else {
            return helper(nums, i + 1, sum, target);
        }
    }
}
