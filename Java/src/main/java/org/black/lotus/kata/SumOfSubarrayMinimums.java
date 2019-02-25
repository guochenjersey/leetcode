package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

 Since the answer may be large, return the answer modulo 10^9 + 7.



 Example 1:

 Input: [3,1,2,4]
 Output: 17
 Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.

1. 一开始考虑暴力DFS, 做的不好,主要是没想出来,连续子数组是怎么写.
 * */
@LeetCode
@Medium
@FirstRound
@DP
@NoIdeaOrBadIdeaInitially
public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] nums) {
        List<Integer> subArray = new ArrayList<>();
        return 0;
    }

}
