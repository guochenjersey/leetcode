package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

  public List<List<Integer>> permute(int[] nums) {
    // DFS 的套路,首先定义全部结果的结果集.
    List<List<Integer>> results = new ArrayList<>();
    if (nums == null) {
      return results;
    }

    if (nums.length == 0) {
      results.add(new ArrayList<>());
      return results;
    }
    // 定义一个空的结果集
    List<Integer> permutation = new ArrayList<>();
    // 定义一个保存走过路径的集合或者是链表
    Set<Integer> set = new HashSet<>();
    // 递归解决问题
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
