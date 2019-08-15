package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.List;

@LeetCode
@Medium
public class LetterCombinationOfAPhoneNumber {
    private static final Character[] PLACE_HOLDER = new Character[] {};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if ("".equals(digits)) {
            return res;
        }

        List<Character[]> letters = new ArrayList<>();
        letters.add(PLACE_HOLDER);
        letters.add(PLACE_HOLDER);

        letters.add(new Character[]{'a', 'b', 'c'});
        letters.add(new Character[]{'d', 'e', 'f'});
        letters.add(new Character[]{'g', 'h', 'i'});
        letters.add(new Character[]{'j', 'k', 'l'});
        letters.add(new Character[]{'m', 'n', 'o'});
        letters.add(new Character[]{'p', 'q', 'r', 's'});
        letters.add(new Character[]{'t', 'u', 'v'});
        letters.add(new Character[]{'w', 'x', 'y', 'z'});

        char[] chars = digits.toCharArray();
        List<Character[]> toPermute = new ArrayList<>();
        for (char c : chars) {
            toPermute.add(letters.get(Character.digit(c, 10)));
        }

        helper(toPermute, res, digits.length(), "");

        return res;
    }

    private void helper(List<Character[]> chars,
                        List<String> results,
                        int len,
                        String res) {
        if (res.length() == len) {
            results.add(res);
            return;
        }
        List<Character[]> copyOfOriginal = new ArrayList<>(chars);

        for (Character[] characters : chars) {
            for (char c : characters) {
                res += c;
                copyOfOriginal.remove(characters);
                helper(copyOfOriginal, results, len, res);
                res = res.substring(0, res.length() - 1);
            }
        }
    }
}
