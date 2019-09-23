package org.black.lotus.kata;


import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
@LeetCode
@Easy
@Accepted
public class ClaimingStairs {

    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        return helper(new HashMap<>(), n);
    }

    private int helper(Map<Integer, Integer> resMap, int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (resMap.containsKey(n)) {
            return resMap.get(n);
        }

        int way = helper(resMap, n - 1) + helper(resMap, n - 2);
        resMap.put(n, way);

        return way;
    }
}
