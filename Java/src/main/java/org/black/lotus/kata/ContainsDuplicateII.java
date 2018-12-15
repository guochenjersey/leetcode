package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.*;
import java.util.stream.Collectors;


/**
 *
 *
 Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

 Example 1:

 Input: nums = [1,2,3,1], k = 3
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1
 Output: true
 Example 3:

 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false
 *
 * */
@LeetCode
@FirstRound
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        List<List<Integer>> filteredList = map.values()
                .stream()
                .filter(l -> l.size() > 1)
                .collect(Collectors.toList());

        for (List<Integer> l : filteredList) {
            Collections.sort(l);
            for (int i = 0; i < l.size(); ++i) {
                if (i + 1 < l.size()) {
                    if (l.get(i + 1) - l.get(i) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
