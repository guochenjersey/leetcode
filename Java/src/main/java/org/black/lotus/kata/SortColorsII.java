package org.black.lotus.kata;


import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

/**
 *
 * Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

 Notice
 You are not suppose to use the library's sort function for this problem.

 k <= n

 Example
 Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

 Challenge
 A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?


 * */
@FirstRound
@LintCode
@Medium
@Accepted
public class SortColorsII {

    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }

        quickSort(colors, 0, colors.length - 1);
    }

    private void quickSort(int[] colors, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = colors[(start + end) / 2];
        while (left <= right) {
            while (left <= right && colors[left] < pivot) {
                ++left;
            }

            while (left <= right && colors[right] > pivot) {
                --right;
            }

            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                ++left;
                --right;
            }
        }

        quickSort(colors, start, right);
        quickSort(colors, left, end);
    }
}
