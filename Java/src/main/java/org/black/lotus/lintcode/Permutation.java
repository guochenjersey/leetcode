package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    if (nums == null) {
      return results;
    }

    if (nums.length == 0) {
      results.add(new ArrayList<>());
      return results;
    }

    List<Integer> permutation = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    helper(nums, permutation, set, results);
    return results;
  }

  private void helper(int[] nums,
                      List<Integer> permutation,
                      Set<Integer> set,
                      List<List<Integer>> results) {

    if (permutation.size() == nums.length) {
      results.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (set.contains(nums[i])) {
        continue;
      }

      permutation.add(nums[i]);
      set.add(nums[i]);
      helper(nums, permutation, set, results);
      // 将搜索树退回到上层
      set.remove(nums[i]);
      permutation.remove(permutation.size() - 1);
    }
  }

}
