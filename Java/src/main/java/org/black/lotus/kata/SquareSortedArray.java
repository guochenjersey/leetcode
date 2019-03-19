package org.black.lotus.kata;

import java.util.Arrays;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of
 * each number, also in sorted non-decreasing order.
 *
 * <p>Example 1:
 *
 * <p>Input: [-4,-1,0,3,10] Output: [0,1,9,16,100] Example 2:
 *
 * <p>Input: [-7,-3,2,3,11] Output: [4,9,9,49,121]
 */
@LeetCode
@Easy
@FirstRound
public class SquareSortedArray {

  public int[] sortedSquares(int[] A) {
    if (A == null || A.length == 0) {
      return null;
    }
    for (int i = 0; i < A.length; ++i) {
      A[i] = A[i] * A[i];
    }

    Arrays.sort(A);
    return A;
  }
}
