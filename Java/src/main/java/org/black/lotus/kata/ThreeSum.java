package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> results = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      twoSum(nums, 0 - nums[i], i, results);
    }

    return new ArrayList<>(results);
  }

  private void twoSum(int[] nums,
      int target,
      int excludeIndex,
      Set<List<Integer>> results) {
    Map<Integer, List<Integer>> numsMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      if (i != excludeIndex) {
        numsMap.putIfAbsent(nums[i], new ArrayList<>());
        numsMap.get(nums[i]).add(i);
      }
    }

    for (int i = 0; i < nums.length; ++i) {
      if (i != excludeIndex) {
        if (numsMap.containsKey(target - nums[i])) {
          List<Integer> posIndex = numsMap.get(target - nums[i]);

          if (posIndex.size() == 1 && posIndex.get(0).equals(i)) {
            // if the number is num[i] itself
            continue;
          }

          result.add(nums[i]);
          result.add(target - nums[i]);
          result.add(nums[excludeIndex]);
          result.sort(Comparator.comparingInt(l -> l));
          results.add(new ArrayList<>(result));
          result.clear();
        }
      }
    }
  }

  /**
   * ThreeSum DFS doesn't work because of the time searching takes too long.
   * */
  public List<List<Integer>> dfsThreeSum(int[] nums) {
    Set<List<Integer>> results = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    Set<Integer> visitedIndex = new HashSet<>();
    helper(results, result, nums, visitedIndex);
    return new ArrayList<>(results);
  }

  private void helper(Set<List<Integer>> results,
                      List<Integer> result,
                      int[] nums,
                      Set<Integer> visitedIndex) {
    System.out.println("Searching");
    if (result.size() == 3
        && result.stream().mapToInt(i -> i).sum() == 0) {
      result.sort(Comparator.comparingInt(l -> l));
      results.add(new ArrayList<>(result));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (visitedIndex.contains(i)) {
        continue;
      }
      result.add(nums[i]);
      visitedIndex.add(i);
      helper(results, result, nums, visitedIndex);
      result.remove(result.size() - 1);
      visitedIndex.remove(new Integer(i));
    }

  }
}
