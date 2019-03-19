package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;

/**
 * Find the last position of a target number in a sorted array. Return -1 if target does not exist.
 *
 * <p>Have you met this question in a real interview? Example Given [1, 2, 2, 4, 5, 5].
 *
 * <p>For target = 2, return 2.
 *
 * <p>For target = 5, return 5.
 *
 * <p>For target = 6, return -1.
 */
@FirstRound
@LintCode
@Accepted
@Important
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
