package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.SubarraySum;

import java.util.HashMap;
import java.util.Map;

@LeetCode
@Medium
@Important
@SubarraySum
@Accepted("16%")
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> appearedChars = new HashMap<>();
        char[] chars = s.toCharArray();
        int currentMax = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (!appearedChars.containsKey(chars[i])) {
                appearedChars.put(chars[i], i);
                ++currentMax;
                max = Math.max(currentMax, max);
            } else {
                final Integer idx = appearedChars.remove(chars[i]);
                currentMax = i - idx;
                max = Math.max(currentMax, max);
                appearedChars.put(chars[i], i);
                appearedChars.entrySet().removeIf(entry -> entry.getValue() <= idx);
            }
        }

        return max;
    }
}
