package org.black.lotus.kata;

public class LastPositionOfTarget {

  /** In a sorted array, which I assume ascending order here. */
  public int lastPosition(int[] source, int target) {
    if (source == null || source.length == 0) {
      return -1;
    }

    int start = 0, end = source.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (target == source[mid]) {
        start = mid;
      } else if (target > source[mid]) {
        start = mid;
      } else if (target < source[mid]) {
        end = mid;
      }
    }

    if (target == source[end]) {
      return end;
    }

    if (target == source[start]) {
      return start;
    }

    return -1;
  }
}
