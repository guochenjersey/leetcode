package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

@LeetCode
@Medium
@Accepted("very slow beat only 5%")
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

  private void helper(
      int[] nums, List<Integer> permutation, Set<List<Integer>> results, List<Integer> position) {
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
}
