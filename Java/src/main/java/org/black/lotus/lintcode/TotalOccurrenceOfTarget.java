package org.black.lotus.lintcode;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

@LintCode
@FirstRound
public class TotalOccurrenceOfTarget {

  public int totalOccurrence(int[] source, int target) {
    if (source == null || source.length == 0) {
      return 0;
    }

    int sourceLength = source.length;

    if (source[0] > target || source[sourceLength - 1] < target) {
      return 0;
    }

    int start = 0;
    int end = source.length - 1;
    int occurance = 0;
    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (source[middle] == target) {
        int leftBound = findBound(start, middle, target, source, true);
        int rightBound = findBound(middle, end, target, source, false);
        return rightBound - leftBound + 1;
      }

      if (source[middle] > target) {
        end = middle;
      }

      if (source[middle] < target) {
        start = middle;
      }
    }

    if (source[start] == target) {
      ++occurance;
    }
    if (source[end] == target) {
      ++occurance;
    }

    return occurance;
  }

  private int findBound(int start,
      int end,
      int target,
      int[] source,
      boolean lowerBound) {
    int index = -1;
    while (start + 1 < end) {
      int middle = start + (end - start) / 2;
      if (source[middle] == target) {
        index = middle;
        if (lowerBound) {
          end = middle;
        } else {
          start = middle;
        }
      }

      if (source[middle] > target) {
        end = middle;
      }

      if (source[middle] < target) {
        start = middle;
      }
    }

    if (source[start] == target) {
      if (lowerBound) {
        index = start;
      } else if (index == -1) {
        index = start;
      }
    }

    if (source[end] == target) {
      if (!lowerBound) {
        index = end;
      } else if (index == -1) {
        index = end;
      }
    }
    return index;
  }
}
