package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 *
 * Given two strings s and t which consist of only lowercase letters.

 String t is generated by random shuffling string s and then add one more letter at a random position.

 Find the letter that was added in t.

 Example:

 Input:
 s = "abcd"
 t = "abcde"

 Output:
 e

 Explanation:
 'e' is the letter that was added.
 * */
@LeetCode
@Easy
@FirstRound
@Accepted
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] tMap = new int[256];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        for (char c : s.toCharArray()) {
            tMap[c]--;
        }

        for (int i = 0; i < 256; ++i) {
            if (tMap[i] != 0) {
                return (char)i;
            }
        }

        return 'c';
    }
}
