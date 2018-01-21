package org.black.lotus.lintcode;

/**
 * TODO
 * */
public class SplitLinkedListsInParts {

  public ListNode[] splitListToParts(ListNode root, int k) {
    ListNode[] nodesArray = new ListNode[k];

    return nodesArray;
  }

  private int findListLength(ListNode root) {
    int length = 0;
    while (root.next != null) {
      ++length;
      root = root.next;
    }
    return length;
  }
}
