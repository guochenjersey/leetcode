package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.HaveNotCheckAnswer;
import org.black.lotus.marker.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 * <p>
 * Return the largest string X such that X divides str1 and X divides str2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * <p>
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters.
 */
@LeetCode
@Easy
@Accepted
@HaveNotCheckAnswer
public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        String res = "";
        String longStr = str1.length() > str2.length() ? str1 : str2;
        String shortStr = str1.length() > str2.length() ? str2 : str1;

        for (String s = shortStr; s.length() != 0; ) {
            if (isDivisor(shortStr, s)) {
                if (isDivisor(longStr, s)) {
                    return s;
                }
            }
            s = s.substring(0, s.length() - 1);
        }


        return res;
    }

    private int hashVal(String str) {
        int val = 0;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            val += c;
        }

        return val;
    }

    public boolean isDivisor(String str, String divisor) {
        if (divisor.length() > str.length()) {
            return false;
        }

        int val1 = hashVal(str);
        int val2 = hashVal(divisor);
        if (val1 % val2 != 0) {
            return false;
        }

        int divisorLen = divisor.length();
        while (str.length() != 0) {
            if (!str.startsWith(divisor) || str.length() % divisorLen != 0)
                return false;
            str = str.substring(divisorLen);
        }

        return true;
    }
}
