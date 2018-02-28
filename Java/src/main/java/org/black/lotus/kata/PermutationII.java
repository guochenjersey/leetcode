package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationII {

  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> results = new HashSet<>();
    // paths you've gone so far
    ArrayList<Integer> paths = new ArrayList<>();
    // one qualified result
    ArrayList<Integer> res = new ArrayList<>();
    helper(nums, res, results, paths);
    return new ArrayList<>(results);
  }

  private void helper(int[] nums,
                      List<Integer> permutation,
                      Set<List<Integer>> results,
                      List<Integer> position) {
    if (permutation.size() == nums.length) {
      results.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (position.contains(i)) {
        continue;
      }
      permutation.add(nums[i]);
      position.add(i);
      helper(nums, permutation, results, position);
      position.remove(new Integer(i));
      permutation.remove(permutation.size() - 1);
    }
  }

  public static void main(String... args) {
    int[] nums = {1, 2, 2};
    PermutationII permutationII = new PermutationII();
    permutationII.permuteUnique(nums)
        .stream().forEach(l -> {
          l.stream().forEach(System.out::print);
      System.out.println();
    });
  }
}
