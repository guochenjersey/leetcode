package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.
 * */
@LeetCode
@Easy
@FirstRound
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int res = 0;
        String s = Integer.toBinaryString(x);
        for (Character c : s.toCharArray()) {
            if (c == '1') {
                ++res;
            }
        }

        return res;
    }
}
