package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
@LeetCode
@FirstRound

public class AddBinary {
    public String addBinary(String a, String b) {
        String res = "";
        int s = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while( i >= 0 || j >= 0 || s == 1 ) {
            s += (i >= 0) ? a.charAt(i) - '0' : 0;
            s += (j >= 0) ? b.charAt(j) - '0' : 0;

            res = (char)(s % 2 + '0') + res;
            s /= 2;
            --i;
            --j;
        }

        return res;
    }
}
