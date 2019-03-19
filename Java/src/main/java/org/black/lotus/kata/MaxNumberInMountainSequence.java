package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
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
public class MaxNumberInMountainSequence {

  public int mountainSequence(int[] source) {
    int start = 0;
    int end = source.length - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (isPeak(mid, source)) {
        return source[mid];
      }

      if (source[start] < source[mid]) {
        if (source[mid] < source[mid + 1]) {
          start = mid;
        } else {
          end = mid;
        }
      } else if (source[mid] < source[end]) {
        if (source[mid] > source[mid + 1]) {
          end = mid;
        } else {
          start = mid;
        }
      } else if (source[mid] > source[end]) {
        if (source[mid] > source[mid + 1]) {
          end = mid;
        }
      }
    }

    return Math.max(source[start], source[end]);
  }

  private boolean isPeak(int mid, int[] nums) {
    return nums.length == 1
        || (nums.length == 2 && nums[mid] > nums[mid + 1])
        || (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]);
  }
}
