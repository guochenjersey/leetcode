package org.black.lotus;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * TODO
 */
public class Kata139 {

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        boolean[] dp = new boolean[s.length()];
        for ( int i = 0; i < s.length(); ++i ) {
            for (String keyWord : dict) {

            }
        }

        return dp[s.length() - 1];
    }
}
