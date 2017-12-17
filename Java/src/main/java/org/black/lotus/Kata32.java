package org.black.lotus;

import java.util.ArrayDeque;
import junit.framework.Assert;
import org.junit.Test;

public class Kata32 {
  private static final char leftParenthesis = '(';
  private static final char rightParenthesis = ')';

  public int longestValidParentheses(String s) {
    int max = 0, curMax = 0;
    if (s == null) {
      return -1;
    }

    char[] chars = s.toCharArray();
    ArrayDeque<Character> deque = new ArrayDeque<>();
    for (char c : chars) {
      if (c == rightParenthesis) {
        Character e = deque.pollFirst();
        if (e != null && e == leftParenthesis) {
          curMax += 2;
        } else {
          curMax = 0;
        }
      }
      max = Math.max(max, curMax);

      if (c == leftParenthesis) {
        deque.offerFirst(c);
      }
    }

    return max;
  }

  @Test
  public void testParen() {
    Kata32 kata32 = new Kata32();
    Assert.assertEquals(kata32.longestValidParentheses(")()()"), 4);
    Assert.assertEquals(kata32.longestValidParentheses("()(()"), 2);
  }
}
