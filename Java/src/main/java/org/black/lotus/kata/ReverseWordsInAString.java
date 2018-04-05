package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NeedToSubmit;

@FirstRound
@Medium
@NeedToSubmit
public class ReverseWordsInAString {

    public String reverse(String source) {
        StringBuilder result = new StringBuilder();
        int index = source.length() - 1;
        int start = -1;
        int end = -1;
        while (index >= 0) {
            char c = source.charAt(index);
            if (c == ' ') {
                if (start != -1 && end != -1) {
                    result.append(source.substring(start, end + 1));
                }
                result.append(c);
                start = -1;
                end = -1;
                --index;
                continue;
            }
            if (end == -1) {
                end = index;
                start = index;
            } else {
                start = index;
            }
            --index;
        }

        return result.toString();
    }
}
