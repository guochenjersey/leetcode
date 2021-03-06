package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the
 * resulting image.
 *
 * <p>To flip an image horizontally means that each row of the image is reversed. For example,
 * flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * <p>To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For
 * example, inverting [0, 1, 1] results in [1, 0, 0].
 *
 * <p>Example 1:
 *
 * <p>Input: [[1,1,0],[1,0,1],[0,0,0]] Output: [[1,0,0],[0,1,0],[1,1,1]] Explanation: First reverse
 * each row: [[0,1,1],[1,0,1],[0,0,0]]. Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]] Example 2:
 *
 * <p>Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]] Output:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]] Explanation: First reverse each row:
 * [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]. Then invert the image:
 * [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
@LeetCode
@Easy
@FirstRound
public class FlipAnImage {

  public int[][] flipAndInvertImage(int[][] A) {
    for (int[] a : A) {
      reverseAndInvert(a);
    }

    return A;
  }

  private void reverseAndInvert(int[] array) {
    for (int i = 0, j = array.length - 1; i < j; ++i, --j) {
      int tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
    }

    for (int i = 0; i < array.length; ++i) {
      array[i] = array[i] == 1 ? 0 : 1;
    }
  }
}
