package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.Arrays;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

就是说只要字母一样,字母出现的次数一样的两个字符串就是anagram
 * */
@LeetCode
@Easy
@FirstRound
@Accepted
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] tMap = new int[26];
        int[] sMap = new int[26];
        for (char a : t.toCharArray()) {
            tMap[a - 'a']++;
        }

        for (char c : s.toCharArray()) {
            sMap[c - 'a']++;
        }

        return Arrays.equals(sMap, tMap);
    }
}
