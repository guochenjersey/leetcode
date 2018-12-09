package org.black.lotus.kata;


import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

@LeetCode
@Medium
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) {
            return res;
        }

        for (int i = 0; i < height.length - 1; ++i) {
            for (int j = i + 1; j < height.length; ++j) {
                int area = (j - i) * Math.min(height[i], height[j]);
                res = Math.max(area, res);
            }
        }
        return res;
    }
}
