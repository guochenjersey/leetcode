package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.TwoPointer;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
@LeetCode
@Easy
@TwoPointer
public class ReverseString {
    public String reverseString(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return new String(chars);
    }
}
