package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Share
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * */
@LeetCode
@FirstRound
@Medium
public class ReverseWordsInAString {

    public String reverse(String source) {
        if (source == null) {
            return null;
        }

        if (source.length() == 0) {
            return source;
        }

        int start = 0, end = source.length() - 1;
        char[] chars = source.toCharArray();
        while(chars[start] == ' ' && start < source.length()) {
            ++start;
        }
        while(chars[end] == ' ' && end > 0) {
            --end;
        }

        if (start == end) {
            return "";
        }
        String result ="";
        StringBuilder word = new StringBuilder();
        while (start <= end) {
            if (chars[start] != ' ') {
                word.append(chars[start]);
            } else {
                result = word.toString() + " " + result;
                word = new StringBuilder();
            }

            ++start;
        }

        return result;
    }
}
