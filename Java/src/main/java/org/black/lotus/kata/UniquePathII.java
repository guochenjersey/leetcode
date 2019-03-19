package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

@LeetCode
@Medium
public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; ++i) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                continue;
            }
            if (i - 1 >= 0) {
                dp[i][0] = dp[i - 1][0] == 0 ? 0 : 1;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 0; i < obstacleGrid[0].length; ++i) {

        }

        return 0;
    }
}
