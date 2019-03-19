package org.black.lotus.kata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs
 * in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both
 * numbers in the array and their absolute difference is k.
 *
 * <p>Example 1: Input: [3, 1, 4, 1, 5], k = 2 Output: 2 Explanation: There are two 2-diff pairs in
 * the array, (1, 3) and (3, 5). Although we have two 1s in the input, we should only return the
 * number of unique pairs. Example 2: Input:[1, 2, 3, 4, 5], k = 1 Output: 4 Explanation: There are
 * four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5). Example 3: Input: [1, 3, 1, 5,
 * 4], k = 0 Output: 1 Explanation: There is one 0-diff pair in the array, (1, 1). Note: The pairs
 * (i, j) and (j, i) count as the same pair. The length of the array won't exceed 10,000. All the
 * integers in the given input belong to the range: [-1e7, 1e7].
 */
@LeetCode
@Easy
@FirstRound
public class KDiffPairsInAnArray {

  public int findPairs(int[] nums, int k) {
    Arrays.sort(nums);
    Set<Pair> res = new HashSet<>();
    for (int i = 0, j = 1; i < nums.length && j < nums.length; ) {
      if (nums[j] - nums[i] == k) {
        res.add(new Pair(nums[i], nums[j]));
        ++i;
        ++j;
        continue;
      }

      if (nums[j] - nums[i] < k) {
        ++j;
      } else {
        ++i;
        if (i == j) {
          ++j;
        }
      }
    }

    return res.size();
  }

  class Pair {
    private int left;
    private int right;

    public Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public int hashCode() {
      return Integer.hashCode(left) + Integer.hashCode(right);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Pair pair = (Pair) o;

      if (left != pair.left) return false;
      return right == pair.right;
    }
  }
}
