package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

/**
 *Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:

 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:

 Input: "race a car"
 Output: false
 * */
@LeetCode
@Easy
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < j;) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                --j;
                continue;
            }

            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }

            ++i;
            --j;
        }

        return true;
    }
}
