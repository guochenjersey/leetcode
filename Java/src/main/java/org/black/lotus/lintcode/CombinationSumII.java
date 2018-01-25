package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSumII {

  public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    List<Integer> path = new ArrayList<>();
    Set<Integer> visitedIndex = new HashSet<>();
    helper(result, nums, path, target, 0, visitedIndex);
    return removeDuplicate(result);
  }


  List<List<Integer>> removeDuplicate(List<List<Integer>> res) {
    Set<List<Integer>> resultSet = new HashSet<>();
    for (List<Integer> l : res) {
      resultSet.add(l.stream().sorted().collect(Collectors.toList()));
    }

    return new ArrayList<>(resultSet);
  }

  private void helper(List<List<Integer>> results,
      int[] nums,
      List<Integer> path,
      int target,
      int sum,
      Set<Integer> visitedIndex) {
    if (sum == target) {
      results.add(new ArrayList<>(path));
      return;
    }
    if (sum > target) {
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (visitedIndex.contains(i)) {
        continue;
      }
      visitedIndex.add(i);
      path.add(nums[i]);
      sum += nums[i];
      helper(results, nums, path, target, sum, visitedIndex);
      sum -= nums[i];
      path.remove(path.size() - 1);
      visitedIndex.remove(new Integer(i));
    }
  }

  void test() {
    int[] nums = {2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> lists = combinationSum2(nums, target);
    lists.stream().forEach(l -> {
      l.stream().forEach(n -> {
        System.out.print(n + " \t");
      });
      System.out.println();
    });
  }
}
