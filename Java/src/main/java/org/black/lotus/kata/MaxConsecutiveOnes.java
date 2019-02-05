package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
@LeetCode
@FirstRound
@Easy
@Accepted
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int maxConsecutiveOnes = 0;
        for (int i = 0; i < nums.length; ++i) {
            int tmp = sum;
            sum += nums[i];
            if (sum > tmp) {
                maxConsecutiveOnes = Math.max(sum, maxConsecutiveOnes);
            } else {
                sum = 0;
            }
        }

        return maxConsecutiveOnes;
    }
}
