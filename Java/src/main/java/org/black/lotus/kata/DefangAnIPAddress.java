package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *
 *
 * Constraints:
 *
 * The given address is a valid IPv4 address.
 * */
@LeetCode
@Easy
@FirstRound
public class DefangAnIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        char[] chars = address.toCharArray();
        for (char c : chars) {
            if (c != '.') {
                res.append(c);
            } else {
                res.append('[').append('.').append(']');
            }
        }

        return res.toString();
    }
}
