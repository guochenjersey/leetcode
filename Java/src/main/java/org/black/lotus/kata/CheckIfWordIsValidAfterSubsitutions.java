package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * We are given that the string "abc" is valid.
 * <p>
 * From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.
 * <p>
 * If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".
 * <p>
 * Return true if and only if the given string S is valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "aabcbc"
 * Output: true
 * Explanation:
 * We start with the valid string "abc".
 * Then we can insert another "abc" between "a" and "bc", resulting in "a" + "abc" + "bc" which is "aabcbc".
 * Example 2:
 * <p>
 * Input: "abcabcababcc"
 * Output: true
 * Explanation:
 * "abcabcabc" is valid after consecutive insertings of "abc".
 * Then we can insert "abc" before the last letter, resulting in "abcabcab" + "abc" + "c" which is "abcabcababcc".
 * Example 3:
 * <p>
 * Input: "abccba"
 * Output: false
 * Example 4:
 * <p>
 * Input: "cababc"
 * Output: false
 */
@LeetCode
@Medium
@Accepted
public class CheckIfWordIsValidAfterSubsitutions {

    private static final String PATTERN = "abc";

    public boolean isValid(String source) {
        if (source == null || source.length() < 3) {
            return false;
        }
        int remainLen = source.length();
        String tmp = source;
        while (remainLen > 0) {
            int lastIdx = tmp.lastIndexOf(PATTERN);
            if (lastIdx != -1) {
                String before = tmp.substring(0, lastIdx);
                String after = tmp.substring(lastIdx + 3);
                tmp = before + after;
                remainLen = tmp.length();
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean fasterIsValid(String S) {
        int k = 0;
        int i = 0;
        char[] ch = S.toCharArray();
        while(i < S.length()) {
            if(ch[i] == 'c' && (k > 1) && ch[k - 1] == 'b' && ch[k - 2] == 'a') {
                k -= 2;
                i++;
            } else {
                ch[k] = ch[i];
                k++;
                i++;
            }
        }
        return k == 0;
    }
}
