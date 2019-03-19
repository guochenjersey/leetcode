package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.SlidingWindow;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * <p>Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 *
 * <p>The order of output does not matter.
 *
 * <p>Example 1:
 *
 * <p>Input: s: "cbaebabacd" p: "abc"
 *
 * <p>Output: [0, 6]
 *
 * <p>Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc". The
 * substring with start index = 6 is "bac", which is an anagram of "abc". Example 2:
 *
 * <p>Input: s: "abab" p: "ab"
 *
 * <p>Output: [0, 1, 2]
 *
 * <p>Explanation: The substring with start index = 0 is "ab", which is an anagram of "ab". The
 * substring with start index = 1 is "ba", which is an anagram of "ab". The substring with start
 * index = 2 is "ab", which is an anagram of "ab".
 *
 * <p>Need to understand how it works 双指针,滑动窗口
 */
@LeetCode
@Easy
@FirstRound
@SlidingWindow
public class FindAllAnagramsInAString {

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s == null || s.length() == 0 || p == null || p.length() == 0) return result;
    int[] hash = new int[256];
    char[] pp = p.toCharArray();
    for (char i : pp) {
      hash[i]++;
    }
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
      if (hash[s.charAt(right++)]-- > 0) // 窗口右移；相应的hash值减小；如果这个位置的Hash值是正的，表示p字符串也包含这个，所以count做减法
      count--;
      if (count == 0) result.add(left); // count指示器，为0表示和p对应的hash值完全一致
      if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
        // 如果当窗口大小一定的时候即窗口大小和需要比较的字符串大小一致的时候，将窗口左边的指针向右边移动，移动的同时左边的字符计数因为在第一个if的地方hash值减小过，所以需要执行对应恢复操作，即：hash值增加，count计数值增加。
        count++;
    }
    return result;
  }
}
