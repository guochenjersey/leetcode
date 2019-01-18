package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.NotAccepted;

/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 Example 1:

 Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
 jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * dfs can solve the right answer but the time complexivity is too high. DP should be
 * the solution
 * */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
@NotAccepted
public class JumpGame {

    public boolean canJump(int[] nums) {
        int[] records = new int[nums.length];
        return canJumpDP(0, nums, records);
    }


    private boolean canJumpDP(int i, int[] nums, int[] records) {
        if (records[i] == 1) {
            return true;
        }

        if (records[i] == 2) {
            return false;
        }

        if (i + nums[i] >= nums.length - 1) {
            return true;
        }

        for (int j = i + 1; j <= (i + nums[i]); ++j) {
            if (canJumpDP(j, nums, records)) {
                records[j] = 1;
                return true;
            }
        }
        records[i] = 2;
        return false;
    }

    private boolean canJumpDfsSolution(int[] nums) {
        if (nums == null && nums.length == 0) {
            return false;
        }

        return dfs(0, nums);
    }

    private boolean dfs(int pos,
                     int[] nums) {
        if (pos == (nums.length - 1) ||
                (nums[pos] >= (nums.length - pos - 1))) {
            return true;
        }

        if (pos > (nums.length - 1)) {
            return false;
        }

        for (int i = 1; i <= nums[pos]; ++i) {
            boolean res = dfs(pos + i, nums);
            if (res) {
                return true;
            }
        }

        return false;
    }

}
