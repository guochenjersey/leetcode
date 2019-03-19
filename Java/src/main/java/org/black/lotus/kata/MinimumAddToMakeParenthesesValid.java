package org.black.lotus.kata;

import java.util.ArrayDeque;
import java.util.Deque;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or
 * ')', and in any positions ) so that the resulting parentheses string is valid.
 *
 * <p>Formally, a parentheses string is valid if and only if:
 *
 * <p>It is the empty string, or It can be written as AB (A concatenated with B), where A and B are
 * valid strings, or It can be written as (A), where A is a valid string. Given a parentheses
 * string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 * <p>
 *
 * <p>
 *
 * <p>Example 1:
 *
 * <p>Input: "())" Output: 1 Example 2:
 *
 * <p>Input: "(((" Output: 3 Example 3:
 *
 * <p>Input: "()" Output: 0 Example 4:
 *
 * <p>Input: "()))((" Output: 4
 */
@LeetCode
@Medium
@FirstRound
public class MinimumAddToMakeParenthesesValid {

  public int minAddToMakeValid(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    char[] chars = s.toCharArray();
    Deque<Character> deque = new ArrayDeque<>();
    for (char c : chars) {
      if (deque.size() == 0) {
        deque.offerFirst(c);
      } else {
        char top = deque.peekFirst();
        if (top == '(' && c == ')') {
          deque.pollFirst();
        } else {
          deque.offerFirst(c);
        }
      }
    }
    return deque.size();
  }
}
