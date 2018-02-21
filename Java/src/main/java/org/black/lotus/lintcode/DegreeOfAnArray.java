package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Google;
import org.black.lotus.marker.HaveNotCheckAnswer;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

@LeetCode
@Google
@NoIdeaOrBadIdeaInitially
@Accepted
@HaveNotCheckAnswer
public class DegreeOfAnArray {

  class Tuple {
    int fromIndex;
    int endIndex;

    Tuple (int i, int j) {
      this.fromIndex = i;
      this.endIndex = j;
    }

    int distance() {
      return this.endIndex - this.fromIndex + 1;
    }
  }

  public int findShortestSubArrayLintCode(int[] nums) {
    if (nums == null) {
      return 0;
    }

    Map<Integer, Tuple> rangeMap = new HashMap<>();
    Map<Integer, Integer> appearanceMap = new HashMap<>();

    for (int i = 0; i < nums.length; ++i) {
      final int currIndex = i;
      rangeMap.computeIfAbsent(nums[i], j -> new Tuple(currIndex, currIndex));
      rangeMap.computeIfPresent(nums[i], (k, v) -> new Tuple(v.fromIndex, currIndex));
      appearanceMap.putIfAbsent(nums[i], 0);
      appearanceMap.computeIfPresent(nums[i], (k, v) -> ++v);
    }

    int shortestSubArrayLength = 0;
    int mostAppearence = 0;

    for (Entry<Integer, Integer> entry : appearanceMap.entrySet()) {
      if (entry.getValue() > mostAppearence) {
        mostAppearence = entry.getValue();
        shortestSubArrayLength = rangeMap.get(entry.getKey()).distance();
      } else if (entry.getValue() == mostAppearence) {
        shortestSubArrayLength = Math
            .min(shortestSubArrayLength, rangeMap.get(entry.getKey()).distance());
      }
    }

    return shortestSubArrayLength;
  }

  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> frequencyMap = frequencyMap(nums);
    Map<Integer, Integer> mostFrequetIntegers = numsHavingBiggestFrequency(frequencyMap);
    int shortestSubstringLength = 0;
    List<Integer> shortestSet = new ArrayList<>();
    for (Entry<Integer, Integer> entry : mostFrequetIntegers.entrySet()) {
      boolean firstAppear = false;
      for (int i = 0; i < nums.length; ++i) {
        if (entry.getKey().equals(nums[i])) {
          if (!firstAppear) {
            firstAppear = true;
          }
          entry.setValue(entry.getValue() - 1);
        }
        if (firstAppear) {
          ++shortestSubstringLength;
        }

        if (entry.getValue() == 0) {
          shortestSet.add(shortestSubstringLength);
          shortestSubstringLength = 0;
          break;
        }
      }
    }

    Collections.sort(shortestSet);
    return shortestSet.get(0);
  }

  private Map<Integer, Integer> numsHavingBiggestFrequency (Map<Integer, Integer> frequencyMap) {
    Map<Integer, Integer> res = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>(frequencyMap.values());
    Collections.sort(list);
    Integer mostFrequent = list.get(list.size() - 1);
    frequencyMap.entrySet().stream()
        .forEach(entry -> {
          if (entry.getValue().equals(mostFrequent)) {
            res.put(entry.getKey(), entry.getValue());
          }
        });
    return res;
  }

  private Map<Integer, Integer> frequencyMap(int[] nums) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int i : nums) {
      frequencyMap.putIfAbsent(i, 0);
      frequencyMap.computeIfPresent(i, (k, v) -> ++v);
    }
    return frequencyMap;
  }
}
