package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

/**
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is
 * repeated N times.
 *
 * <p>Return the element repeated N times.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,2,3,3] Output: 3 Example 2:
 *
 * <p>Input: [2,1,2,5,3,2] Output: 2 Example 3:
 *
 * <p>Input: [5,1,5,2,5,3,5,4] Output: 5 4 <= A.length <= 10000 0 <= A[i] < 10000 A.length is even
 */
@LeetCode
@Easy
public class NRepeatedElementInSize2NArray {

  public int repeatedNTimes(int[] source) {
    int[] counter = new int[10000];
    for (int i : source) {
      counter[i] = ++counter[i];
      if (counter[i] > 2) {
        return i;
      }
    }

    return -1;
  }
}
