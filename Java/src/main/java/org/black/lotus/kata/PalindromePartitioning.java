package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  /** 这道题目的关键是顺序移动. */
  public List<List<String>> partition(String s) {
    List<List<String>> results = new ArrayList<>();
    List<String> result = new ArrayList<>();
    int startedIndex = 0; // 定义起始点
    helper(s, startedIndex, results, result);
    return results;
  }

  private void helper(String s, int startIndexes, List<List<String>> results, List<String> result) {

    if (startIndexes == s.length()) {
      results.add(new ArrayList<>(result));
      return;
    }
    for (int i = startIndexes; i < s.length(); ++i) {
      String str = s.substring(startIndexes, i + 1); // 到目前为止的子串是否符合要求
      if (!isPalindrome(str)) {
        continue;
      }

      result.add(str);
      // 从符合要求的子串index开始继续遍历.
      helper(s, i + 1, results, result);
      result.remove(result.size() - 1);
    }
  }

  /** Check if string is palindrome */
  boolean isPalindrome(String toCheck) {
    if ("".equals(toCheck)) {
      return true;
    }

    for (int i = 0, j = toCheck.length() - 1; i < j; ++i, --j) {
      if (toCheck.charAt(i) != toCheck.charAt(j)) {
        return false;
      }
    }

    return true;
  }
}
