package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.NotAccepted;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True
 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.
 *
 * */
@LeetCode
@Easy
@NotAccepted
@NoIdeaOrBadIdeaInitially
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                ++start;
                --end;
                continue;
            }

            String skipStart = s.substring(start + 1, end + 1);
            if (isValidPalindrome(skipStart)) {
                return true;
            }

            String skipEnd = s.substring(start, end);
            if (isValidPalindrome(skipEnd)) {
                return true;
            }

            return false;
        }

        return true;
    }

    private boolean isValidPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }
}
