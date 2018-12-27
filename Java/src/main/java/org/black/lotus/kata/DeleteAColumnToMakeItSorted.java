package org.black.lotus.kata;


import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

@LeetCode
@FirstRound
@Easy
public class DeleteAColumnToMakeItSorted {

    public int minDeletionSize(String[] source) {
        int res = 0;
        for (int i = 0; i < source[0].length(); ++i) {
            for (int j = 0; j < source.length; ++j) {
                if (j + 1 < source.length) {
                    if (source[j].charAt(i) > source[j + 1].charAt(i)) {
                        return i;
                    }
                }
            }
        }

        return res;
    }

}
