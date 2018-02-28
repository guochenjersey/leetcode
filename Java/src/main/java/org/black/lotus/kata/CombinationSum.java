package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

  public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null) {
      return result;
    }
    List<Integer> path = new ArrayList<>();
    helper(result, nums, path, target, 0);
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
                      int sum) {
    if (sum == target) {
      results.add(new ArrayList<>(path));
      return;
    }
    if (sum > target) {
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      path.add(nums[i]);
      sum += nums[i];
      helper(results, nums, path, target, sum);
      sum -= nums[i];
      path.remove(path.size() -1);
    }
  }

  void test() {
    int[] nums = {2, 3, 6, 7};
    int target = 7;
    List<List<Integer>> lists = combinationSum(nums, target);
    lists.stream().forEach(l -> {
      l.stream().forEach(n -> {
        System.out.print(n + " \t");
      });
      System.out.println();
    });
  }

  public static void main(String... args) {
    CombinationSum combinationSum = new CombinationSum();
    combinationSum.test();
  }
}
