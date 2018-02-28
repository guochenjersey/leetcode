package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
  /*
   * DFS search all possible results.
   */
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null) {
      return null;
    }
    List<List<Integer>> results = new ArrayList<>();

    if (nums.length == 0) {
      results.add(Collections.emptyList());
      return results;
    }

    Arrays.sort(nums);

    helper(new ArrayList<>(), nums, 0, results);

    return results;
  }

  private void helper(
      List<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results) {
    results.add(new ArrayList<>(subset));
    for (int i = startIndex; i < nums.length; i++) {
      subset.add(nums[i]);
      helper(subset, nums, i + 1, results);
      subset.remove(subset.size() - 1);
    }
  }
}
