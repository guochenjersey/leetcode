package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.
 *
 * */
@LeetCode
@FirstRound
@Easy
@NoIdeaOrBadIdeaInitially
public class ShortestUnsortedContinuousSubArray {

    public int findUnsortedSubarray(int[] nums) {
        int[] target = new int[nums.length];
        System.arraycopy(nums, 0, target, 0, nums.length);
        Arrays.sort(target);
        int start = -1;
        int end = -1;
        for (int i = 0, j = nums.length - 1; i < j;) {
            if (start != -1 && end != -1) {
                break;
            }
            if (nums[i] != target[i] && start == -1) {
                start = i;
            }
            if (start == -1) {
                ++i;
            }

            if (nums[j] != target[j] && end == -1) {
                end = j;
            }
            if (end == -1) {
                --j;
            }
        }

        return end == start ? 0 : end - start + 1;
    }
}
