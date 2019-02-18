package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
@LeetCode
@Easy
@FirstRound
@Accepted
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c == ' ') {
                Collections.reverse(list);
                list.forEach(res::append);
                res.append(' ');
                list.clear();
            } else {
                list.add(c);
            }
        }

        if (list.size() != 0) {
            Collections.reverse(list);
            list.forEach(res::append);
        }

        return res.toString();
    }
}
