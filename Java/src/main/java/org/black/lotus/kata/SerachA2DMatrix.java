package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.NeedToSubmit;

@FirstRound
@NeedToSubmit
public class SerachA2DMatrix {

  public boolean search(int[][] array, int target) {
    boolean result = false;
    if (array == null || array.length == 0) {
      return result;
    }

    for (int[] row : array) {
      if (row[0] > target || row[row.length - 1] < target) {
        continue;
      }

      int start = 0;
      int end = row.length - 1;
      while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (row[mid] == target) {
          return true;
        } else if (row[mid] < target) {
          start = mid;
        } else if (row[mid] > target) {
          end = mid;
        }
      }

      if (row[start] == target || row[end] == target) {
        return true;
      } else {
        return false;
      }
    }

    return result;
  }
}
