package org.black.lotus.kata;

import java.util.*;

public class TwoSumUniquePairs {

  public int twoSum6(int[] nums, int target) {
    int res = 0;
    if (nums == null || nums.length == 0) {
      return res;
    }

    // Arrays.sort(nums);
    Map<Integer, Integer> resMap = new HashMap<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; ++i) {
      for (int j = nums.length - 1; i < j; ) {
        int sum = nums[i] + nums[j];
        if (sum == target) {
          resMap.put(nums[i], nums[j]);
          --j;
        } else if (sum < target) {
          break;
        } else {
          --j;
        }
      }
    }

    return resMap.size();
  }
}
