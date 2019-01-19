package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 *
 * */
@LeetCode
@FirstRound
@Medium
@NeedToSubmit
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Integer[][] minVal = new Integer[grid.length][grid[0].length];
        return minPath(grid, 0, 0, 0, minVal);
    }

    private int minPath(int[][] grid,
                        int row,
                        int col,
                        int sum,
                        Integer[][] minVal) {
        if (minVal[row][col] != null) {
            return minVal[row][col];
        }
        sum += grid[row][col];

        if (row == (grid.length -1 )
                && col == (grid[0].length - 1)) {
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
