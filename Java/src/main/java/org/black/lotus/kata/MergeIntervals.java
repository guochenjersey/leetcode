package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * */
@LeetCode
@Medium
@Accepted
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[res.size()][]);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] cur = intervals[0];
        for (int[] next : intervals) {
            if (next[0] <= cur[1] && next[1] > cur[1]) {
                cur[1] = next[1];
            } else if (next[0] > cur[1]) {
                res.add(cur);
                cur = next;
            }
        }
        res.add(cur);

        return res.toArray(new int[res.size()][]);
    }
}
