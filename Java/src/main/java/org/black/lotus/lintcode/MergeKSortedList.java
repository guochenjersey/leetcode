package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class MergeKSortedList {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode res = null;
    if (lists == null || lists.length == 0) {
      return res;
    }
    List<ListNode> nodes = new ArrayList<>();
    for (ListNode node : lists) {
      while (node != null) {
        nodes.add(node);
        node = node.next;
      }
    }

    List<ListNode> sorted = nodes.stream()
        .sorted(Comparator.comparingInt(l -> l.val))
        .collect(Collectors.toList());
    return arrange(sorted);
  }

  private ListNode arrange(List<ListNode> nodes) {
    if (nodes.size() == 0) {
      return null;
    }

    ListNode head = nodes.get(0);
    ListNode curr = head;
    ListIterator<ListNode> listIterator = nodes.listIterator();
    while (listIterator.hasNext()) {
      curr.next = listIterator.next();
      curr = curr.next;
    }

    curr.next = null;
    return head;
  }

  public static void main(String... args) {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(0);

    ListNode[] nodes = {one, two};
    MergeKSortedList mergeKSortedList = new MergeKSortedList();
    mergeKSortedList.mergeKLists(nodes);
  }
}
