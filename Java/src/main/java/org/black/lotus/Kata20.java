package org.black.lotus;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/** How to convert from char array to list */
public class Kata20 {

  private static final Map<Character, Character> symbols = new HashMap<>();
  private static final Map<Character, Character> reverseSymbols = new HashMap<>();

  {
    symbols.put('(', ')');
    symbols.put('{', '}');
    symbols.put('[', ']');

    reverseSymbols.put(')', '(');
    reverseSymbols.put('}', '{');
    reverseSymbols.put(']', '[');
  }

  public boolean isValid(String s) {
    if (s == null) {
      return false;
    }
    if (s.length() == 0) {
      return true;
    }
    ArrayDeque<Character> deque = new ArrayDeque<>();
    char[] chars = s.toCharArray();
    for (char aChar : chars) {
      if (symbols.keySet().contains(aChar)) {
        deque.offerFirst(aChar);
      } else {
        Character first = deque.pollFirst();
        if (!reverseSymbols.get(aChar).equals(first)) {
          return false;
        }
      }
    }
    return deque.isEmpty();
  }
}
