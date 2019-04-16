package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.HashMap;
import java.util.Map;

/**
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 *
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (42.37%)
 * Total Accepted:    37.4K
 * Total Submissions: 88.3K
 * Testcase Example:  '[0,1]'
 *
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 *
 *
 * Example 1:
 *
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of
 * 0 and 1.
 *
 * Example 2:
 *
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
 *
 *
 *
 * Note:
 * The length of the given binary array will not exceed 50,000.
 *
 */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
@Accepted("90%")
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int max = 0;
        int sum  = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                --sum;
            } else {
                ++sum;
            }
            if (sum == 0) {
                max = Math.max(max, i + 1);
                continue;
            }

            if (map.get(sum) != null) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }
}
