package org.black.lotus.kata;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.Zillow;

@Zillow
@Accepted
@NoIdeaOrBadIdeaInitially
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

