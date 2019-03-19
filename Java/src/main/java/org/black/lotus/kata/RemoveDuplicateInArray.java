package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NotAccepted;

/**
 * Given an array of integers, remove the duplicate numbers in it.
 *
 * <p>You should: 1. Do it in place in the array. 2. Move the unique numbers to the front of the
 * array. 3. Return the total number of the unique numbers.
 *
 * <p>Notice You don't need to keep the original order of the integers.
 *
 * <p>Have you met this question in a real interview? Example Given nums = [1,3,1,4,4,2], you
 * should:
 *
 * <p>Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?]. Return the number of
 * unique integers in nums => 4. Actually we don't care about what you place in ?, we only care
 * about the part which has no duplicate integers.
 *
 * <p>Challenge Do it in O(n) time complexity. Do it in O(nlogn) time without extra space.
 *
 * <p>TODO
 */
@FirstRound
@Accepted
@LeetCode
@NotAccepted
public class RemoveDuplicateInArray {

  public int deduplication(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    LinkedHashSet<Integer> res = new LinkedHashSet<>();
    for (int i : nums) {
      if (i != 0) {
        res.add(i);
      }
    }

    int j = 0;
    for (int i : res) {
      nums[j] = i;
      ++j;
    }

    return j;
  }
}
