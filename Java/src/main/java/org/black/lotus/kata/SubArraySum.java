package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySum {

  public List<Integer> subarraySum(int[] nums) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> sumsMap = new HashMap<>();
    sumsMap.put(0, -1);
    int sum = 0;
    for (int i = 0; i < nums.length; ++i) {
      sum += nums[i];
      if (sumsMap.containsKey(sum)) {
        result.add(sumsMap.get(sum) + 1);
        result.add(i);
        return result;
      }

      sumsMap.put(sum, i);
    }
    return result;
  }

  public static void main(String... args) {
    int[] nums = {-3, 1, 2, 4, 5};
    SubArraySum subArraySum = new SubArraySum();
    subArraySum.subarraySum(nums).stream().forEach(System.out::println);
  }
}
