package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Implement a stack with min() function, which will return the smallest number in the stack.
 *
 * <p>It should support push, pop and min operation all in O(1) cost.
 *
 * <p>Notice min operation will never be called if there is no number in the stack.
 *
 * <p>Have you met this question in a real interview? Example push(1) pop() // return 1 push(2)
 * push(3) min() // return 2 push(1) min() // return 1 Tags
 */
@LintCode
@FirstRound
@NoIdeaOrBadIdeaInitially
public class MinStack {

  private Stack<Integer> stack;
  private Stack<Integer> minStack;

  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int number) {
    stack.push(number);
    if (minStack.isEmpty()) {
      minStack.push(number);
    } else {
      minStack.push(Math.min(number, minStack.peek()));
    }
  }

  public int pop() {
    minStack.pop();
    return stack.pop();
  }

  public int min() {
    return minStack.peek();
  }

  public int top() {
    return stack.peek();
  }
}
