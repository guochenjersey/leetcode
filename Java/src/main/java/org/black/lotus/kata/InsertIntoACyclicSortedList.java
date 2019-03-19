package org.black.lotus.kata;

import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

@LintCode
@Amazon
@NoIdeaOrBadIdeaInitially
@FirstRound
public class InsertIntoACyclicSortedList {

  public ListNode insert(ListNode node, int x) {
    if (node == null) {
      node = new ListNode(x);
      node.next = node;
      return node;
    }

    ListNode temp = node;
    ListNode prev;
    // 关键点在于先做循环体内的东西. 第二,直接通过内存地址比较两个节点相同或者不同.
    do {
      prev = temp;
      temp = temp.next;
      if (prev.val <= x && x <= temp.val) {
        break;
      }

      if (prev.val > temp.val && (x < temp.val || x > prev.val)) {
        break;
      }

    } while (temp != node);

    ListNode newNode = new ListNode(x);
    newNode.next = temp;
    prev.next = newNode;
    return newNode;
  }
}
