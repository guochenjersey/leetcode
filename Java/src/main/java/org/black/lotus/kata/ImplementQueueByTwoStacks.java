package org.black.lotus.kata;

import java.util.Stack;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Yahoo;

@FirstRound
@LintCode
@Yahoo
@Accepted
public class ImplementQueueByTwoStacks {
  private Stack<Integer> stack1;
  private Stack<Integer> stack2;

  public ImplementQueueByTwoStacks() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  /*
   * @param element: An integer
   * @return: nothing
   */
  public void push(int element) {
    stack1.push(element);
    stack2.clear();
  }

  /*
   * @return: An integer
   */
  public int pop() {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    Integer res = stack2.pop();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    return res;
  }

  /*
   * @return: An integer
   */
  public int top() {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
    Integer res = stack2.peek();
    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }

    return res;
  }
}
