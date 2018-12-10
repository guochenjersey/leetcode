package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.math.BigInteger;
import java.util.Arrays;

@LeetCode
@FirstRound
@Medium
@Accepted
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1]) {
                    return nums[i];
                }
            }
        }

        return -1;
    }
}
