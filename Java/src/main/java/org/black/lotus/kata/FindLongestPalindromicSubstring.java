package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Google;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.NotAccepted;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Google
@Important
@NotAccepted
@FirstRound
/**
 * https://www.felix021.com/blog/read.php?2040
 * */
public class FindLongestPalindromicSubstring {

    static class Result {
        String res;
    }

    static class Range {
        int fromIndex;
        int toIndex;

        Range(int i, int j) {
            this.fromIndex = i;
            this.toIndex = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Range range = (Range) o;

            if (fromIndex != range.fromIndex) return false;
            return toIndex == range.toIndex;
        }

        @Override
        public int hashCode() {
            int result = fromIndex;
            result = 31 * result + toIndex;
            return result;
        }
    }


    public String longestPalindrome(String source) {
        Result result = new Result();
        result.res = "";
        Set<Range> resSet = new HashSet<>();
        dfs(result, 0, source, resSet);

        return result.res;
    }

    public void dfs(Result result, int start, String source, Set<Range> resSet) {
        if (result.res.length() == source.length()
                || (start == source.length())) {
            return;
        }

        for (int i = start; i <= source.length(); ++i) {
            String subStr = source.substring(start, i);
            if (resSet.contains(new Range(start, i)) || isPalindrom(subStr)) {
                resSet.add(new Range(start, i));
                if (subStr.length() > result.res.length()) {
                    result.res = subStr;
                }
            } else {
                dfs(result, start + 1, source, resSet);
            }
        }

    }

    private boolean isPalindrom(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        String str = "tattarrattat";
        FindLongestPalindromicSubstring findLongestPalindromicSubstring = new FindLongestPalindromicSubstring();
        System.out.println(findLongestPalindromicSubstring.longestPalindrome(str));
    }
}
