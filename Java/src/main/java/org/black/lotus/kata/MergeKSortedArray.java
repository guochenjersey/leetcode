package org.black.lotus.kata;


import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description
 Given k sorted integer arrays, merge them into one sorted array.

 Have you met this question in a real interview?
 Example
 Given 3 sorted arrays:

 [
 [1, 3, 5, 7],
 [2, 4, 6],
 [0, 8, 9, 10, 11]
 ]
 return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

 Challenge
 Do it in O(N log k).

 N is the total number of integers.
 k is the number of arrays.
 *
 * @see MergeKSortedList
 * */
@LintCode
@Medium
@Accepted
public class MergeKSortedArray {

    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }
        int size = 0;

        for (int[] array : arrays) {
            size += array.length;
        }

        if (size == 0) {
            return new int[0];
        }

        Queue<Integer> minHeap = new PriorityQueue<>(size);
        for (int[] array : arrays) {
            for (int i : array) {
                minHeap.offer(i);
            }
        }
        int[] res = new int[size];
        for (int i = 0; minHeap.isEmpty(); ++i) {
            res[i] = minHeap.poll();
        }

        return res;
    }
}
