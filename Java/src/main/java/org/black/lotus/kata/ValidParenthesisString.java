package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to
 * check whether this string is valid. We define the validity of a string by these rules:
 *
 * <p>Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any right
 * parenthesis ')' must have a corresponding left parenthesis '('. Left parenthesis '(' must go
 * before the corresponding right parenthesis ')'. '*' could be treated as a single right
 * parenthesis ')' or a single left parenthesis '(' or an empty string. An empty string is also
 * valid. Example 1: Input: "()" Output: True Example 2: Input: "(*)" Output: True Example 3: Input:
 * "(*))" Output: True
 */
@LeetCode
@Medium
@FirstRound
@Accepted
@NoIdeaOrBadIdeaInitially
public class ValidParenthesisString {

  public boolean checkValidString(String s) {
    int left = 0, right = 0;
    for (int i = 0; i < s.length(); ++i) {
      // 从左向右扫描,如果全部看成左括号的话
      if (s.charAt(i) == '(' || s.charAt(i) == '*') {
        ++left;
      } else {
        --left;
      }

      if (left < 0) {
        // 这说明有)没有被匹配
        return false;
      }
    }

    if (left == 0) {
      return true;
    }

    for (int i = s.length() - 1; i > -1; --i) {
      if (s.charAt(i) == ')' || s.charAt(i) == '*') {
        right++;
      } else {
        right--;
      }
      if (right < 0) {
        // 说明有(没有被匹配
        return false;
      }
    }

    // 假如全看*成左括号匹配有剩余,全看*成右括号匹配也有剩余,说明把部分*看成左括号刚好平衡.
    return true;
  }
}
