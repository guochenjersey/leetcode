package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) {
            return results;
        }
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> subset, List<Integer> nums) {
        results.add(subset);
        for (int i = 0; i< nums.size(); ++i) {
            subset.add(nums.get(i));
        }
    }

    private List<Integer> cloneArray(List<Integer> source) {
        List<Integer> clone = new ArrayList<>();
        clone.addAll(source);
        return source;
    }

}
