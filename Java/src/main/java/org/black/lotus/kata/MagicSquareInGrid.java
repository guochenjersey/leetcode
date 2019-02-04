package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

 Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).

 Example 1:

 Input: [[4,3,8,4],
 [9,5,1,9],
 [2,7,6,2]]
 Output: 1
 Explanation:
 The following subgrid is a 3 x 3 magic square:
 438
 951
 276

 while this one is not:
 384
 519
 762

 In total, there is only one magic square inside the given grid.
 Note:

 1 <= grid.length <= 10
 1 <= grid[0].length <= 10
 0 <= grid[i][j] <= 15
 *
 *
 *
 * */
@LeetCode
@FirstRound
@Easy
public class MagicSquareInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid.length; ++j) {
                if (isMagicGrid(grid, i, j)) {
                    ++res;
                }
            }
        }

        return res;
    }

    private boolean isMagicGrid(int[][] grid, int rowStart, int colStart) {
        int coLength = grid[0].length;
        if (rowStart + 3 > grid.length || colStart + 3 > grid[0].length) {
            return false;
        }

        Set<Integer> sumSet = new HashSet<>();
        int c = colStart;
        Set<Integer> distinctNums = new HashSet<>();
        for (int i = rowStart; i < rowStart + 3; ++i) {
            int sum = 0;
            for (int j = colStart; j < colStart + 3; ++j) {
                sum += grid[i][j];
                distinctNums.add(grid[i][j]);
            }
            sumSet.add(sum);
            if (sumSet.size() > 1) {
                return false;
            }
        }

        if (distinctNums.size() != 9) {
            return false;
        } else {
            for (int i = 1; i < 10; ++i) {
                if (!distinctNums.contains(i)) {
                    return false;
                }
            }
        }

        for (int i = colStart; i < colStart + 3; ++i) {
            int sum = 0;
            for (int j = rowStart; j < rowStart + 3; ++j) {
                sum += grid[j][i];
            }
            sumSet.add(sum);
            if (sumSet.size() > 1) {
                return false;
            }
        }

        int sum = grid[rowStart][colStart]
                + grid[rowStart+1][colStart + 1]
                + grid[rowStart + 2][colStart + 2];
        sumSet.add(sum);
        if (sumSet.size() > 1) {
            return false;
        }

        sum = grid[rowStart][colStart + 2]
                + grid[rowStart + 1][colStart + 1]
                + grid[rowStart + 2][colStart];
        sumSet.add(sum);
        if (sumSet.size() > 1) {
            return false;
        }

        return true;
    }
}
