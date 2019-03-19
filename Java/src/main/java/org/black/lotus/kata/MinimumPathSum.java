package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * <p>Note: You can only move either down or right at any point in time.
 *
 * <p>Example:
 *
 * <p>Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because the path 1→3→1→1→1
 * minimizes the sum.
 *
 * <p>TODO to check the correct answer
 */
@LeetCode
@FirstRound
@Medium
@NotAccepted
public class MinimumPathSum {

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    Integer[][] minVal = new Integer[grid.length][grid[0].length];
    return minPath(grid, 0, 0, 0, minVal);
  }

  private int minPath(int[][] grid, int row, int col, int sum, Integer[][] minVal) {
    if (minVal[row][col] != null) {
      return minVal[row][col];
    }
    sum += grid[row][col];

    if (row == (grid.length - 1) && col == (grid[0].length - 1)) {
      return sum;
    }

    int toRight = Integer.MAX_VALUE, toDown = Integer.MAX_VALUE;
    if (col + 1 < grid[0].length) {
      toRight = minPath(grid, row, col + 1, sum, minVal);
    }

    if (row + 1 < grid.length) {
      toDown = minPath(grid, row + 1, col, sum, minVal);
    }

    minVal[row][col] = Math.min(toRight, toDown);

    return Math.min(toRight, toDown);
  }
}
