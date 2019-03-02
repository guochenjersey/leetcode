package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.

 Example 1:

 Input: "12"
 Output: 2
 Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 Example 2:

 Input: "226"
 Output: 3
 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * */
@LeetCode
@Medium
@FirstRound
@Facebook
@Accepted
public class DecodeWays {
    private int sum;

    /**
     * Note that the input could be 01, 50, 80 which is invalid and can't decode.
     * */
    public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

        sum = 0;
        helper(s.toCharArray(), 0);

        return sum;
    }

    private void helper(char[] chars,
                        int index) {
        if (index > (chars.length - 1)) {
            ++sum;
            return;
        }

        if (index + 1 <= chars.length - 1) {
            int t = Integer.valueOf(String.valueOf(chars[index]) + String.valueOf(chars[index + 1]));
            if (t == 0 || (t / 10 == 0)) {
                return;
            }
            if (t < 27 && (t % 10 != 0)) {
                helper(chars, index + 1);
                helper(chars, index + 2);
            } else if (t < 27 && (t % 10 == 0)){
                helper(chars, index + 2);
            } else if (t > 26 && (t % 10 != 0)) {
                helper(chars, index + 1);
            } else {
                return;
            }
        } else {
            if (chars[index] == '0')
                return;
            helper(chars, index + 1);
        }
    }
}
