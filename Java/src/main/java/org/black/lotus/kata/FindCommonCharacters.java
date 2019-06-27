package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order
 * <p>
 * Example 1:
 * <p>
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * <p>
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 */
@LeetCode
@Easy
public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] counter = init(A[0]);
        for (int i = 1; i < A.length; ++i) {
            char[] chars = A[i].toCharArray();
            int[] tmp = new int[26];
            for (char c : chars) {
                tmp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                counter[j] = Math.min(counter[j], tmp[j]);
            }
        }

        for (int k = 0; k < 26; ++k) {
            int s = counter[k];
            while (s > 0) {
                char c = (char)('a' + k);
                char[] tmp = new char[1];
                tmp[0] = c;
                res.add(new String(tmp));
                --s;
            }
        }
        return res;
    }

    private int[] init(String s) {
        char[] chars = s.toCharArray();
        int[] tmp = new int[26];
        for (char c : chars) {
            tmp[c - 'a']++;
        }

        return tmp;
    }
}
