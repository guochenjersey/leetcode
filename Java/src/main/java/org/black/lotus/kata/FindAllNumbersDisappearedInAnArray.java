package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Maths;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * <p>Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * <p>Could you do it without extra space and in O(n) runtime? You may assume the returned list does
 * not count as extra space.
 *
 * <p>Example:
 *
 * <p>Input: [4,3,2,7,8,2,3,1]
 *
 * <p>Output: [5,6]
 */
@LeetCode
@Easy
@FirstRound
@Maths
public class FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    BitSet bitSet = new BitSet();
    for (int i = 0; i < nums.length; ++i) {
      bitSet.set(nums[i]);
    }
    for (int i = 1; i <= nums.length; ++i) {
      if (!bitSet.get(i)) {
        res.add(i);
      }
    }

    return res;
  }
}
