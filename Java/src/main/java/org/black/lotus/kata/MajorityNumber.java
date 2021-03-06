package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Given an array of integers, the majority number is the number that occurs more than half of the
 * size of the array. Find it. Notice You may assume that the array is non-empty and the majority
 * number always exist in the array.
 *
 * <p>Challenge O(n) time and O(1) extra space
 */
@FirstRound
@LintCode
@Accepted
public class MajorityNumber {

  public int majorityNumber(List<Integer> nums) {
    int threshHold = nums.size() / 2;
    Map<Integer, Integer> occuranceMap = new HashMap<>();
    for (Integer i : nums) {
      occuranceMap.putIfAbsent(i, 0);
      int occurance = occuranceMap.get(i) + 1;
      if (occurance > threshHold) {
        return i;
      }
      occuranceMap.put(i, occurance);
    }

    return -1;
  }

  public int majorityNumberAnswer(ArrayList<Integer> nums) {
    int count = 0, candidate = -1;
    for (int i = 0; i < nums.size(); i++) {
      if (count == 0) {
        candidate = nums.get(i);
        count = 1;
      } else if (candidate == nums.get(i)) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
