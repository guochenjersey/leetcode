package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * */
@LeetCode
@FirstRound
@Easy
public class RotateStringLeetCode {

    public boolean rotateString(String A, String B) {
        if (A == null && B == null) {
            return true;
        }

        boolean hasNull = A == null || B == null;
        if (hasNull || A.length() != B.length()) {
            return false;
        }
        if (A.equals("") && B.equals("")) {
            return true;
        }
        String str = A;
        for (int i = 0; i < A.length(); ++i) {
            char c = str.charAt(0);
            str = str.substring(1, A.length());
            str = str + c;
            if (str.equals(B)) {
                return true;
            }
        }

        return false;
    }

}
