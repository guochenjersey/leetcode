package org.black.lotus;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 * Hint : DP
 *
 *
 * ######################################## solution
 * 此题还可以用动态规划Dynamic Programming来解，根Palindrome Partitioning II 拆分回文串之二的解法很类似，
 * 我们维护一个二维数组dp，其中dp[i][j]表示字符串区间[i, j]是否为回文串，
 * 当i = j时，只有一个字符，肯定是回文串，
 * 如果i = j + 1，说明是相邻字符，此时需要判断s[i]是否等于s[j]，
 * 如果i和j不相邻，即i - j >= 2时，除了判断s[i]和s[j]相等之外，dp[j + 1][i - 1]若为真，就是回文串，通过以上分析，可以写出递推式如下：

 dp[i, j] = 1                                               if i == j

 = s[i] == s[j]                                if j = i + 1

 = s[i] == s[j] && dp[i + 1][j - 1]    if j > i + 1

 */
public class Kata5 {

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        if (s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];

        int i, j;

        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < s.length(); j++) {
                if (i >= j) {
                    dp[i][j] = true;

                } else {
                    dp[i][j] = false;
                }
            }
        }

        int maxLen = 1;
        int rf = 0, rt = 0;
        for (int k = 1; k < s.length(); k++) {
            for (i = 0; k + i < s.length(); i++) {
                j = i + k;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        if (k + 1 > maxLen) {
                            maxLen = k + 1;
                            rf = i;
                            rt = j;
                        }
                    }
                }
            }
        }
        return s.substring(rf, rt + 1);
    }
}
