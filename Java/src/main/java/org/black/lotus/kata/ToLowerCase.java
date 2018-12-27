package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

@LeetCode
@Easy
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toLowerCase();
    }
}
