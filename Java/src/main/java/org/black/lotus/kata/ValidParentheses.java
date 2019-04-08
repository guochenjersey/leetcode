package org.black.lotus.kata;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import org.black.lotus.marker.*;

/**
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true
 *
 * */
@Zillow
@Accepted
@LeetCode
@Easy
public class ValidParentheses {

  private Set<Character> inStackSet = new HashSet<>(Arrays.asList('(', '[', '{'));
  private Set<Character> popStackSet = new HashSet<>(Arrays.asList(')', ']', '}'));

  public boolean isValid(String s) {
    if (s == null) {
      return false;
    }

    Deque<Character> deque = new ArrayDeque<>();

    for (int i = 0; i < s.length(); ++i) {
      Character c = s.charAt(i);
      if (deque.isEmpty() && popStackSet.contains(c)) {
        return false;
      }
      if (inStackSet.contains(c)) {
        deque.offerLast(c);
        continue;
      }
      if (popStackSet.contains(c)) {
        Character toCheck = deque.pollLast();
        if (!isPair(toCheck, c)) {
          return false;
        }
      }
    }

    return deque.isEmpty();
  }

  static boolean isPair(Character left, Character right) {
    return (left.equals('(') && right.equals(')'))
        || (left.equals('[') && right.equals(']'))
        || (left.equals('{') && right.equals('}'));
  }
}
