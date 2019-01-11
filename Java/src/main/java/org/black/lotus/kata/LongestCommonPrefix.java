package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
@LeetCode
@Easy
@FirstRound
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder("");
        int minLen = findMinLength(strs);
        for (int i = 0; i < minLen; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (c != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(c);
        }

        return res.toString();
    }

    private int findMinLength(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
        }

        return minLen;
    }
}
