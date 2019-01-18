package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.TwoPointer;

/**
 *
 * Given an array A of integers, return true if and only if it is a valid mountain array.

 Recall that A is a mountain array if and only if:

 A.length >= 3
 There exists some i with 0 < i < A.length - 1 such that:
 A[0] < A[1] < ... A[i-1] < A[i]
 A[i] > A[i+1] > ... > A[B.length - 1]


 Example 1:

 Input: [2,1]
 Output: false
 Example 2:

 Input: [3,5,5]
 Output: false
 Example 3:

 Input: [0,3,2,1]
 Output: true

 Two pointer starting from both head and rear will be better solution for this question.
 * */
@LeetCode
@Easy
@FirstRound
@TwoPointer
public class ValidMountainArray {

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int peak = findPeak(A);
        if (peak == 0 || peak == A.length - 1) {
            return false;
        }

        for (int i = peak; i < A.length - 1; ++i) {
            if (A[i + 1] < A[i]) {
                continue;
            }

            return false;
        }

        for (int i = peak; i > 0; --i) {
            if (A[i - 1] < A[i]) {
                continue;
            }

            return false;
        }

        return true;
    }

    private int findPeak(int[] A) {
        int maxVal = A[0];
        int i = 1;
        int index = 0;
        for (; i < A.length - 1; ++i) {
            if (A[i] > maxVal) {
                maxVal = A[i];
                index = i;
            }
        }

        return index;
    }
}
