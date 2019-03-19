package org.black.lotus.kata;

import java.util.Stack;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/** */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
public class LongestValidParentheses {

  public int longestValidParentheses(String str) {
    int n = str.length();
    Stack<Integer> stk = new Stack<>();
    stk.push(-1);

    // Initialize result
    int result = 0;

    // Traverse all characters of given string
    for (int i = 0; i < n; i++) {
      // If opening bracket, push index of it
      if (str.charAt(i) == '(') stk.push(i);
      else // If closing bracket, i.e.,str[i] = ')'
      {
        // Pop the previous opening bracket's index
        stk.pop();

        // Check if this length formed with base of
        // current valid substring is more than max
        // so far
        if (!stk.empty()) result = Math.max(result, i - stk.peek());

        // If stack is empty. push current index as
        // base for next valid substring (if any)
        else stk.push(i);
      }
    }

    return result;
  }
}
