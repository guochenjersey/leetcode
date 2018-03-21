package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * <p>
 * Example
 * Given "abcdefg".
 * <p>
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * Challenge
 * Rotate in-place with O(1) extra memory.
 */
@FirstRound
@LintCode
@Easy
public class RotateString {

    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }

        offset = offset % str.length;

        for (int i = str.length - 1; offset > 0; --i, --offset) {
            for (int j = str.length -1; j > 0; --j) {
                char temp = str[j];
                str[j] = str[j-1];
                str[j-1] = temp;
            }
        }
    }
}
