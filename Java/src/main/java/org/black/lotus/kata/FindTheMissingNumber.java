package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.Arrays;

@Medium
@LintCode
@FirstRound
public class FindTheMissingNumber {

    public int findMissing(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int expectedSum = (n) * (n +1) / 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        return expectedSum - sum;
    }
}
