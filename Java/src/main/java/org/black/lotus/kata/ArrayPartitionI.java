package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

import java.util.Arrays;

/**
 * 561. Array Partition I
 Easy

 497

 1424

 Favorite

 Share
 Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

 Example 1:
 Input: [1,4,3,2]

 Output: 4
 Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 Note:
 n is a positive integer, which is in the range of [1, 10000].
 All the integers in the array will be in the range of [-10000, 10000].
 Accepted
 121,270
 Submissions
 178,955
 *
 * */
@LeetCode
@Easy
@Accepted
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum  = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}
