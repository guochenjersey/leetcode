package org.black.lotus.kata;

import java.util.ArrayDeque;
import java.util.Deque;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

@FirstRound
@LintCode
@Accepted
@Amazon
public class ReverseNodesInKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 0) {
      return null;
    }

    int groupSize = k;
    Deque<ListNode> nodes = new ArrayDeque<>(groupSize);
    ListNode resHead = null, res = null;
    while (head != null) {
      nodes.offerFirst(head);
      if (nodes.size() == groupSize) {
        // key is to keep a copy of each head
        ListNode headCopy = copyHead(head);

        while (!nodes.isEmpty()) {
          if (resHead == null) {
            resHead = nodes.pollFirst();
            res = resHead;
          } else {
            res.next = nodes.pollFirst();
            res = res.next;
          }
        }
        head = headCopy;
      }
      head = head.next;
    }

    while (!nodes.isEmpty()) {
      if (resHead == null) {
        resHead = nodes.pollLast();
        res = resHead;
      } else {
        res.next = nodes.pollLast();
        res = res.next;
      }
    }

    if (res != null) {
      res.next = null;
    }

    return resHead;
  }

  private ListNode copyHead(ListNode head) {
    ListNode headCopy = new ListNode(head.val);
    headCopy.next = head.next;
    return headCopy;
  }
}
