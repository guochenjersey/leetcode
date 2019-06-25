package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
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
public class FindCommonCharacter {

    public List<String> commonChars(String[] sources) {
        int[] counter = new int[26];
        for (int i = 0; i < sources.length; ++i) {
            String str = sources[i];
            char[] chars = str.toCharArray();
            int[] currentCounter = new int[26];
            for (char c : chars) {
                currentCounter[c - 'a']++;
            }

        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            if (counter[i] != 0) {
                for (int j = 0; j < counter[i]; ++j) {
                    char c = (char) (i + 'a');
                    char[] array = new char[1];
                    array[0] = c;
                    res.add(new String(array));
                }
            }
        }

        return res;
    }
}
