package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

import java.util.Arrays;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students not standing in the right positions.
 * (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * Accepted
 */
@LeetCode
@Easy
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] original = new int[heights.length];
        System.arraycopy(heights, 0, original, 0, heights.length);
        Arrays.sort(heights);
        int diff = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (original[i] != heights[i]) {
                ++diff;
            }
        }

        return diff;
    }
}
