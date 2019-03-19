package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that
 * they add up to a specific target number.
 *
 * <p>The function twoSum should return indices of the two numbers such that they add up to the
 * target, where index1 must be less than index2.
 *
 * <p>Note:
 *
 * <p>Your returned answers (both index1 and index2) are not zero-based. You may assume that each
 * input would have exactly one solution and you may not use the same element twice. Example:
 *
 * <p>Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum of 2 and 7 is 9.
 * Therefore index1 = 1, index2 = 2.
 */
@LeetCode
@FirstRound
@Easy
public class TwoSumIIInputArrayIsSorted {

  public int[] twoSum(int[] numbers, int target) {
    if (numbers == null) {
      return null;
    }
    int[] res = new int[2];
    Map<Integer, List<Integer>> multiMap = new HashMap<>();
    for (int i = 0; i < numbers.length; ++i) {
      multiMap.putIfAbsent(numbers[i], new ArrayList<>());
      multiMap.get(numbers[i]).add(i);
      multiMap.put(numbers[i], multiMap.get(numbers[i]));
    }

    for (int i = 0; i < numbers.length; ++i) {
      if (multiMap.containsKey(target - numbers[i])) {
        List<Integer> nums = multiMap.get(target - numbers[i]);
        if (target - numbers[i] == numbers[i]) {
          if (nums.size() > 1) {
            res[0] = nums.get(0) + 1;
            res[1] = nums.get(1) + 1;
            return res;
          }
        } else {
          res[0] = i + 1;
          res[1] = nums.get(0) + 1;
          return res;
        }
      }
    }
    return res;
  }
}
