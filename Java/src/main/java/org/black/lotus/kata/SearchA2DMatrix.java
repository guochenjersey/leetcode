package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

@LeetCode
@Medium
@FirstRound
@Accepted
public class SearchA2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    for (int i = 0; i < matrix.length; ++i) {
      if (matrix[i][0] == target || matrix[i][matrix[0].length - 1] == target) {
        return true;
      }

      if (matrix[i][0] < target && matrix[i][matrix[0].length - 1] > target) {
        return binarySearch(matrix[i], target);
      }
    }

    return false;
  }

  private boolean binarySearch(int[] array, int t) {
    int start = 0;
    int end = array.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (array[mid] == t) {
        return true;
      }

      if (array[mid] < t) {
        start = mid;
      } else {
        end = mid;
      }
    }

    return (array[start] == t || array[end] == t);
  }
}
