package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.HashMap;
import java.util.Map;

@LeetCode
@Easy
@FirstRound
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return true;
        }
        Map<Character, Integer> orderMap = createOrderMap(order);

        return isValid(words, orderMap);
    }

    private boolean isValid(String[] words, Map<Character, Integer> orderMap) {
        for (int i = 0; i < words.length; ++i) {
            if (i + 1 < words.length) {
                int minLength = Math.min(words[i].length(), words[i + 1].length());
                boolean valid = false;
                for (int j = 0; j < minLength; ++j) {
                    if (orderMap.get(charAt(words[i], j)) < orderMap.get(charAt(words[i + 1], j))) {
                        valid = true;
                        break;
                    }
                    if (orderMap.get(charAt(words[i], j)) > orderMap.get(charAt(words[i + 1], j))) {
                        return false;
                    }
                }
                if (!valid && words[i].length() > words[i + 1].length()) {
                    return false;
                }
            }
        }

        return true;
    }

    private Map<Character, Integer> createOrderMap(String order) {
        int counter = 0;
        Map<Character, Integer> orderMap = new HashMap<>();
        for (char c : order.toCharArray()) {
            orderMap.put(c, ++counter);
        }

        orderMap.put(null, Integer.MIN_VALUE);
        return orderMap;
    }

    private Character charAt(String s, int i) {
        return i >= s.length() ? null : s.charAt(i);
    }
}
