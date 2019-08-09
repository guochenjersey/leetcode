package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * <p>
 * Note:
 * <p>
 *
 * 其实这道题也可以用递归来做，而且思路非常的简单粗暴。就是以字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，结果res自增1，
 * 然后再比较下一对。注意回文字符串有奇数和偶数两种形式，如果是奇数长度，那么i位置就是中间那个字符的位置，
 * 所以我们左右两遍都从i开始遍历；如果是偶数长度的，那么i是最中间两个字符的左边那个，右边那个就是i+1，这样就能cover所有的情况啦，而且都是不同的回文子字符串
 * The input string length won't exceed 1000.
 */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
@Important
@Accepted
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;

        if (len == 0)
            return 0;

        for (int centre = 0; centre < len; centre++) {
            ans++;
            int left = centre - 1;
            int right = centre + 1;

            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }

            left = centre;
            right = centre + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }

        }

        return ans;
    }
}
