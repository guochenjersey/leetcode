package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Medium;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all
 * unique triplets in the array which gives the sum of zero.
 *
 * <p>Notice Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 *
 * <p>The solution set must not contain duplicate triplets.
 *
 * <p>Example For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 *
 * <p>(-1, 0, 1) (-1, -1, 2)
 */
@FirstRound
@Medium
@Amazon
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();

    if (nums == null || nums.length < 3) {
      return results;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      // skip duplicate triples with the same first numebr
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      int left = i + 1, right = nums.length - 1;
      int target = -nums[i];

      twoSum(nums, left, right, target, results);
    }

    return results;
  }

  public void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> results) {
    while (left < right) {
      if (nums[left] + nums[right] == target) {
        ArrayList<Integer> triple = new ArrayList<>();
        triple.add(-target);
        triple.add(nums[left]);
        triple.add(nums[right]);
        results.add(triple);

        left++;
        right--;
        // skip duplicate pairs with the same left
        while (left < right && nums[left] == nums[left - 1]) {
          left++;
        }
        // skip duplicate pairs with the same right
        while (left < right && nums[right] == nums[right + 1]) {
          right--;
        }
      } else if (nums[left] + nums[right] < target) {
        left++;
      } else {
        right--;
      }
    }
  }

  public List<List<Integer>> threeSum_correct_but_slow(int[] nums) {
    Set<List<Integer>> results = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      twoSum(nums, 0 - nums[i], i, results);
    }

    return new ArrayList<>(results);
  }

  private void twoSum(int[] nums, int target, int excludeIndex, Set<List<Integer>> results) {
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

  /** ThreeSum DFS doesn't work because of the time searching takes too long. */
  public List<List<Integer>> dfsThreeSum(int[] nums) {
    Set<List<Integer>> results = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    Set<Integer> visitedIndex = new HashSet<>();
    helper(results, result, nums, visitedIndex);
    return new ArrayList<>(results);
  }

  private void helper(
      Set<List<Integer>> results, List<Integer> result, int[] nums, Set<Integer> visitedIndex) {
    System.out.println("Searching");
    if (result.size() == 3 && result.stream().mapToInt(i -> i).sum() == 0) {
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
