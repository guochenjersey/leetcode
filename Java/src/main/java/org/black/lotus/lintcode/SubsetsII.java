package org.black.lotus.lintcode;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetsII {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> results = new ArrayList<>(512);
    if (nums == null) {
      return new ArrayList<>(results);
    }
    results.add(new ArrayList<>());
    List<Integer> subsets = new ArrayList<>(32);
    List<Integer> position = new ArrayList<>();
    helper(nums, results, subsets, position);

    return removeDuplicate(results);
  }

  private void helper(int[] nums,
                      List<List<Integer>> results,
                      List<Integer> subsets,
                      List<Integer> position) {
    if (position.size() == nums.length) {
      return;
    }

    for (int i = 0; i < nums.length; ++i) {
      if (position.contains(i)) {
        continue;
      }
      subsets.add(nums[i]);
      position.add(i);
      results.add(new ArrayList<>(subsets));
      helper(nums, results, subsets, position);
      position.remove(new Integer(i));
      subsets.remove(subsets.size() - 1);
    }
  }

  List<List<Integer>> removeDuplicate(List<List<Integer>> res) {
    Set<List<Integer>> resultSet = new HashSet<>();
    for (List<Integer> l : res) {
      resultSet.add(l.stream().sorted().collect(Collectors.toList()));
    }

    return new ArrayList<>(resultSet);
  }

  void testResult() {
    int[] nums = {1,2,3,4,5,6,7,8,10,0};
    List<List<Integer>> result = subsetsWithDup(nums);
    System.out.println(result.size());
    result.stream().forEach(l -> {
      l.forEach(i -> {
        System.out.print(i);
        System.out.print("\t");
      });

      System.out.println();
    });
  }

  public static void main(String... args) {
    Instant start = Instant.now();
    SubsetsII subsetsII = new SubsetsII();
    subsetsII.testResult();
    Instant end = Instant.now();
    Duration duration = Duration.between(start, end);
    System.out.println("Taking " + duration.getSeconds());
  }
}
