package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.Arrays;

/**
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 *
 * https://leetcode.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (46.54%)
 * Total Accepted:    264K
 * Total Submissions: 567K
 * Testcase Example:  '3\n2'
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the
 * bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 *
 * Example 2:
 *
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 */
@LeetCode
@Medium
@FirstRound
@DP
@Accepted
@NoIdeaOrBadIdeaInitially
public class UniquePath {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n ==1) {
            return 1;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    @TLESolution
    @DFS
    public int uniquePathsDFS(int m, int n) {
        ObjectHolder objectHolder = new ObjectHolder();
        objectHolder.res = 0;
        if (m == 0 && n == 0) {
            return objectHolder.res;
        }
        helper(m, n, 1, 1, objectHolder);
        return objectHolder.res;
    }

    private void helper(int m,
                        int n,
                        int row,
                        int col,
                        ObjectHolder resHolder) {
        if (m == row && n == col) {
            ++resHolder.res;
            return;
        }

        if (row > m || col > n) {
            return;
        }

        helper(m, n, row + 1, col, resHolder);
        helper(m, n, row, col + 1, resHolder);
    }

    class ObjectHolder {
        public int res;
    }
}
