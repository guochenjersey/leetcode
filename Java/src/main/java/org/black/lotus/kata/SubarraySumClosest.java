package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *
 * Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

 Have you met this question in a real interview?
 Example
 Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

 Challenge
 O(nlogn) time

 Tags

 TODO
 * */
@LintCode
@FirstRound
@Important
@NoIdeaOrBadIdeaInitially
@NotAccepted
public class SubarraySumClosest {

  public int[] subarraySumClosest(int[] nums) {
      int[] res = new int[2];
      int sum = 0;
      int minSum = 0;
      Map<Integer, Integer> sumMap = new LinkedHashMap<>();
      for (int i = 0; i < nums.length; ++i) {
          sum += nums[i];
          if (sumMap.get(sum) != null) {
              res[0] = sumMap.get(sum);
              res[1] = i;
              return res;
          } else {
              sumMap.put(sum, i);
          }
      }


    return res;
  }
}
