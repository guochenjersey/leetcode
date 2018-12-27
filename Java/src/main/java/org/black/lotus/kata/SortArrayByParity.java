package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

@LeetCode
@FirstRound
@Easy
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int[] source = new int[A.length];
        int lowerIndex = 0;
        int upperIndex = A.length - 1;
        for (int i : A) {
            if (i % 2 == 0) {
                source[lowerIndex++] = i;
            } else {
                source[upperIndex--] = i;
            }
        }
        return source;
    }
}
