package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

/**
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.
 * <p>
 * Given a list of three points in the plane, return whether these points are a boomerang.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,3],[3,2]]
 * Output: true
 * Example 2:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: false
 */
@LeetCode
@Easy
public class ValidBoomerang {

    public boolean isBoomerang(int[][] points) {
        int[] point0 = points[0];
        int[] point1 = points[1];
        int[] point2 = points[2];

        boolean isSameX = point0[0] == point1[0] && point0[0] == point2[0];
        boolean isSameY = point0[1] == point1[1] && point0[1] == point2[1];
        if (isSameX || isSameY) {
            return false;
        }

        return (point2[1] - point1[1]) * (point0[0] - point1[0])
                != (point0[1] - point1[1]) * (point2[0] - point1[0]);
    }
}
